package com.brand.es.carrentapp.port.in.web;

import com.brand.es.carrentapp.application.dto.CarDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Car")
@RequestMapping("/car")
public interface CarWebPort {

  @Operation(summary = "Obtain an inventory of cars")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Inventory of cars"),
      @ApiResponse(responseCode = "404", description = "Inventory of cars not Found!"),
      @ApiResponse(responseCode = "500", description = "Server Error!"),})
  @GetMapping
  ResponseEntity<List<CarDTO>> getAllCars();

}
