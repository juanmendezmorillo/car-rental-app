package com.brand.es.carrentapp.application;

import com.brand.es.carrentapp.application.dto.ReservationCreateRequestParamDTO;
import com.brand.es.carrentapp.application.dto.ReservationDTO;
import com.brand.es.carrentapp.application.dto.ReservationDeliverRequestParamDTO;
import java.util.List;
import java.util.Optional;

public interface ReservationService {

  Optional<List<ReservationDTO>> getAllReservations();

  Optional<List<ReservationDTO>> createReservationsAndCalculatePrices(
      List<ReservationCreateRequestParamDTO> reservations);

  Optional<ReservationDTO> returnCarAndCalculateSurcharges(
      ReservationDeliverRequestParamDTO reservation);

}
