package com.brand.es.carrentapp.adapter.out.db;

import com.brand.es.carrentapp.adapter.out.db.model.ReservationEntity;
import com.brand.es.carrentapp.adapter.out.db.repository.ReservationRepository;
import com.brand.es.carrentapp.application.dto.ReservationDTO;
import com.brand.es.carrentapp.port.out.db.ReservationDbPort;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ReservationDbAdapter implements ReservationDbPort {

  private ReservationRepository reservationRepository;
  private ModelMapper modelMapper;

  @Override
  public Optional<List<ReservationDTO>> findAll() {
    return Optional.of(
        reservationRepository.findAll()
            .stream()
            .map(reservationEntity -> modelMapper.map(reservationEntity, ReservationDTO.class))
            .collect(Collectors.toList())
    );
  }

  @Override
  public Optional<ReservationDTO> findById(Long id) {
    return reservationRepository.findById(id)
        .map(reservationEntity -> modelMapper.map(reservationEntity, ReservationDTO.class));
  }

  @Override
  public Optional<ReservationDTO> save(ReservationDTO reservationDTO) {
    ReservationEntity reservationEntity =
        reservationRepository.saveAndFlush(
            modelMapper.map(reservationDTO, ReservationEntity.class));

    return Optional.of(modelMapper.map(reservationEntity, ReservationDTO.class));
  }
}
