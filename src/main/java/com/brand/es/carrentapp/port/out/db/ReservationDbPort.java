package com.brand.es.carrentapp.port.out.db;

import com.brand.es.carrentapp.application.dto.ReservationDTO;
import java.util.List;
import java.util.Optional;

public interface ReservationDbPort {

  Optional<List<ReservationDTO>> findAll();

  Optional<ReservationDTO> findById(Long id);

  Optional<ReservationDTO> save(ReservationDTO reservationDTO);
}
