package com.brand.es.carrentapp.adapter.in.web;

import com.brand.es.carrentapp.application.ReservationService;
import com.brand.es.carrentapp.application.dto.ReservationCreateRequestParamDTO;
import com.brand.es.carrentapp.application.dto.ReservationDTO;
import com.brand.es.carrentapp.application.dto.ReservationDeliverRequestParamDTO;
import com.brand.es.carrentapp.port.in.web.ReservationWebPort;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class ReservationWebAdapter implements ReservationWebPort {

  private ReservationService reservationService;

  @Override
  public ResponseEntity<List<ReservationDTO>> getAllReservations() {
    return new ResponseEntity<>(
        reservationService.getAllReservations().get(), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<List<ReservationDTO>> createReservationsAndCalculatePrices(
      List<ReservationCreateRequestParamDTO> reservations) {
    return new ResponseEntity<>(
        reservationService.createReservationsAndCalculatePrices(reservations).get(), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<ReservationDTO> deliverCarAndCalculateSurcharges(
      ReservationDeliverRequestParamDTO reservation) {
    return new ResponseEntity<>(
        reservationService.returnCarAndCalculateSurcharges(reservation).get(), HttpStatus.OK);
  }

}
