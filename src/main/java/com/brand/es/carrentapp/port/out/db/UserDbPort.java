package com.brand.es.carrentapp.port.out.db;

import com.brand.es.carrentapp.application.dto.UserDTO;
import java.util.List;
import java.util.Optional;

public interface UserDbPort {

  Optional<UserDTO> findById(Long id);

  Optional<List<UserDTO>> findAll();
}
