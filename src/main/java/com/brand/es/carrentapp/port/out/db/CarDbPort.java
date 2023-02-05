package com.brand.es.carrentapp.port.out.db;

import com.brand.es.carrentapp.application.dto.CarDTO;
import java.util.List;
import java.util.Optional;

public interface CarDbPort {

  Optional<CarDTO> findById(Long id);

  Optional<List<CarDTO>> findAll();
}
