package com.brand.es.carrentapp.adapter.out.db;

import com.brand.es.carrentapp.adapter.out.db.repository.CarRepository;
import com.brand.es.carrentapp.application.dto.CarDTO;
import com.brand.es.carrentapp.port.out.db.CarDbPort;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CarDbAdapter implements CarDbPort {

  private CarRepository carRepository;
  private ModelMapper modelMapper;

  @Override
  public Optional<CarDTO> findById(Long id) {
    return carRepository
        .findById(id)
        .map(carEntity -> modelMapper.map(carEntity, CarDTO.class));
  }

  @Override
  public Optional<List<CarDTO>> findAll() {
    return Optional.of(
        carRepository.findAll()
            .stream()
            .map(carEntity -> modelMapper.map(carEntity, CarDTO.class))
            .collect(Collectors.toList())
    );
  }
}
