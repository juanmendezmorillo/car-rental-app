package com.brand.es.carrentapp.port.in.web;

import com.brand.es.carrentapp.application.dto.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "User")
@RequestMapping("/user")
public interface UserWebPort {

  @Operation(summary = "Obtain users")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "List users"),
      @ApiResponse(responseCode = "404", description = "Users not Found!"),
      @ApiResponse(responseCode = "500", description = "Server Error!"),})
  @GetMapping
  ResponseEntity<List<UserDTO>> getAllUsers();

}
