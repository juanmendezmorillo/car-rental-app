package com.brand.es.carrentapp.adapter.in.web;

import com.brand.es.carrentapp.application.UserService;
import com.brand.es.carrentapp.application.dto.UserDTO;
import com.brand.es.carrentapp.port.in.web.UserWebPort;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class UserWebAdapter implements UserWebPort {

  private UserService userService;

  @Override
  public ResponseEntity<List<UserDTO>> getAllUsers() {
    return new ResponseEntity<>(userService.getAllUsers().get(), HttpStatus.OK);
  }
}
