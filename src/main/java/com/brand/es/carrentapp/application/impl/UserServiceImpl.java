package com.brand.es.carrentapp.application.impl;

import com.brand.es.carrentapp.adapter.in.web.exception.NotFoundException;
import com.brand.es.carrentapp.application.UserService;
import com.brand.es.carrentapp.application.dto.UserDTO;
import com.brand.es.carrentapp.port.out.db.UserDbPort;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

  private UserDbPort userDbPort;

  @Override
  public Optional<List<UserDTO>> getAllUsers() {

    List<UserDTO> users = userDbPort.findAll().orElse(new ArrayList<>());

    if (users.isEmpty()) {
      throw new NotFoundException("Users not found");
    }

    return Optional.of(users);
  }
}
