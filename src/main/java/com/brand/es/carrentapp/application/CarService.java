package com.brand.es.carrentapp.application;

import com.brand.es.carrentapp.application.dto.CarDTO;
import java.util.List;
import java.util.Optional;

public interface CarService {

  Optional<List<CarDTO>> getAllCars();

}
