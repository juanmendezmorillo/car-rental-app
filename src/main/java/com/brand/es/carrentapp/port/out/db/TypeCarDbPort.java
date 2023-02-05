package com.brand.es.carrentapp.port.out.db;

import com.brand.es.carrentapp.application.dto.TypeCarDTO;
import java.util.List;
import java.util.Optional;

public interface TypeCarDbPort {

  Optional<List<TypeCarDTO>> findAll();
}
