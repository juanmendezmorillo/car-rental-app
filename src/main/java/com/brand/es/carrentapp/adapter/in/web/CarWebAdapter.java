package com.brand.es.carrentapp.adapter.in.web;

import com.brand.es.carrentapp.application.CarService;
import com.brand.es.carrentapp.application.dto.CarDTO;
import com.brand.es.carrentapp.port.in.web.CarWebPort;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class CarWebAdapter implements CarWebPort {

  private CarService carService;

  @Override
  public ResponseEntity<List<CarDTO>> getAllCars() {
    return new ResponseEntity<>(carService.getAllCars().get(), HttpStatus.OK);
  }
}
