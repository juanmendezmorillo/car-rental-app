package com.brand.es.carrentapp.application.impl;

import com.brand.es.carrentapp.adapter.in.web.exception.InternalException;
import com.brand.es.carrentapp.adapter.in.web.exception.NotFoundException;
import com.brand.es.carrentapp.application.ReservationService;
import com.brand.es.carrentapp.application.dto.ReservationCreateRequestParamDTO;
import com.brand.es.carrentapp.application.dto.ReservationDTO;
import com.brand.es.carrentapp.application.dto.ReservationDeliverRequestParamDTO;
import com.brand.es.carrentapp.domain.CarRental;
import com.brand.es.carrentapp.domain.Reservation;
import com.brand.es.carrentapp.domain.TypeCar;
import com.brand.es.carrentapp.domain.exception.DaysReservationException;
import com.brand.es.carrentapp.port.out.db.CarDbPort;
import com.brand.es.carrentapp.port.out.db.ReservationDbPort;
import com.brand.es.carrentapp.port.out.db.TypeCarDbPort;
import com.brand.es.carrentapp.port.out.db.UserDbPort;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@AllArgsConstructor
@Service
public class ReservationServiceImpl implements ReservationService {

  private ReservationDbPort reservationDbPort;
  private UserDbPort userDbPort;
  private CarDbPort carDbPort;
  private TypeCarDbPort typeCarDbPort;
  private CarRental carRental;
  private ModelMapper modelMapper;

  @Override
  public Optional<List<ReservationDTO>> getAllReservations() {

    List<ReservationDTO> reservations = reservationDbPort.findAll().orElse(new ArrayList<>());

    if (reservations.isEmpty()) {
      throw new NotFoundException("Reservations not found");
    }
    return Optional.of(reservations);
  }

  @Transactional
  @Override
  public Optional<List<ReservationDTO>> createReservationsAndCalculatePrices(
      List<ReservationCreateRequestParamDTO> reservations) {

    log.info("Create reservations and calculate prices: " + reservations);
    return Optional.of(
        reservations
            .stream()
            .map(this::parseReservationCreateRequestParamDTOToReservation)
            .map(this::calculatePriceForReservation)
            .map(this::saveReservation)
            .collect(Collectors.toList())
    );
  }

  private Reservation parseReservationCreateRequestParamDTOToReservation(
      ReservationCreateRequestParamDTO reservation) {

    return modelMapper.map(ReservationDTO
        .builder()
        .carId(carDbPort.findById(reservation.getCarId())
            .orElseThrow(() ->
                new NotFoundException("Car id " + reservation.getCarId() + " not found")))
        .userId(userDbPort.findById(reservation.getUserId())
            .orElseThrow(() ->
                new NotFoundException("User id " + reservation.getUserId() + " not found")))
        .pickUpTime(reservation.getPickUpTime())
        .returnTime(reservation.getReturnTime())
        .build(), Reservation.class);
  }

  private ReservationDTO calculatePriceForReservation(Reservation reservation) {

    try {
      return modelMapper.map(
          carRental.calculatePriceForReservation(reservation), ReservationDTO.class);
    } catch (DaysReservationException ex) {
      log.error("Error calculate price for reservation: " + ex.getMessage());
      throw new InternalException("Error calculate price for reservation: " + ex.getMessage());
    } catch (Exception ex) {
      log.error("Error calculate price for reservation: " + ex.getMessage());
      throw new InternalException("Error calculate price for reservation");
    }
  }

  private ReservationDTO saveReservation(ReservationDTO reservationDTO) {
    try {
      return reservationDbPort.save(reservationDTO).get();
    } catch (Exception ex) {
      log.error("Error save reservation: " + ex.getMessage());
      throw new InternalException("Error save reservation");
    }
  }

  @Override
  public Optional<ReservationDTO> returnCarAndCalculateSurcharges(
      ReservationDeliverRequestParamDTO reservation) {

    log.info("Return car and calculate surcharges: " + reservation);
    ReservationDTO reservationDTO =
        reservationDbPort.findById(reservation.getId())
            .orElseThrow(() ->
                new NotFoundException("Reservation id " + reservation.getId() + " not found"));

    reservationDTO.setReturnTimeReal(reservation.getReturnTimeReal());
    List<TypeCar> typeCars = getAllTypeCars();
    Optional<Reservation> reservationCalculate;

    try {
      reservationCalculate = carRental
          .returnCarAndCalculateSurcharges(
              modelMapper.map(reservationDTO, Reservation.class),
              typeCars
          );
    } catch (Exception ex) {
      log.error("Error calculate surcharge for reservation: " + ex.getMessage());
      throw new InternalException("Error calculate surcharge for reservation");
    }
    return reservationDbPort.save(modelMapper.map(reservationCalculate, ReservationDTO.class));
  }

  private List<TypeCar> getAllTypeCars() {

    return typeCarDbPort
        .findAll()
        .orElseThrow(() -> new NotFoundException("Type cars not found"))
        .stream()
        .map(typeCar -> modelMapper.map(typeCar, TypeCar.class))
        .collect(Collectors.toList());
  }
}
