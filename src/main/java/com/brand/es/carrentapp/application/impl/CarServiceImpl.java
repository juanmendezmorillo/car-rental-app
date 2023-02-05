package com.brand.es.carrentapp.application.impl;

import com.brand.es.carrentapp.adapter.in.web.exception.NotFoundException;
import com.brand.es.carrentapp.application.CarService;
import com.brand.es.carrentapp.application.dto.CarDTO;
import com.brand.es.carrentapp.port.out.db.CarDbPort;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CarServiceImpl implements CarService {

  private CarDbPort carDbPort;

  @Override
  public Optional<List<CarDTO>> getAllCars() {

    List<CarDTO> cars = carDbPort.findAll().orElse(new ArrayList<>());

    if (cars.isEmpty()) {
      throw new NotFoundException("Cars not found");
    }

    return Optional.of(cars);
  }
}
