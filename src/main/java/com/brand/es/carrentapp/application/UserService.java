package com.brand.es.carrentapp.application;

import com.brand.es.carrentapp.application.dto.UserDTO;
import java.util.List;
import java.util.Optional;

public interface UserService {

  Optional<List<UserDTO>> getAllUsers();
}
