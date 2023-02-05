package com.brand.es.carrentapp.port.in.web;

import com.brand.es.carrentapp.application.dto.ReservationCreateRequestParamDTO;
import com.brand.es.carrentapp.application.dto.ReservationDTO;
import com.brand.es.carrentapp.application.dto.ReservationDeliverRequestParamDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Reservation")
@RequestMapping("/reservation")
public interface ReservationWebPort {

  @Operation(summary = "Obtain list reservations")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "List of reservations"),
      @ApiResponse(responseCode = "404", description = "Reservations not Found!"),
      @ApiResponse(responseCode = "500", description = "Server Error!"),})
  @GetMapping
  ResponseEntity<List<ReservationDTO>> getAllReservations();

  @Operation(summary = "Create reservations and obtain prices")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Reservations have been created successfully"),
      @ApiResponse(responseCode = "404", description = "Reservation fields not Found!"),
      @ApiResponse(responseCode = "500", description = "Server Error!"),})
  @PostMapping
  ResponseEntity<List<ReservationDTO>> createReservationsAndCalculatePrices(
      @RequestBody List<ReservationCreateRequestParamDTO> reservations);


  @Operation(summary = "Deliver car")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Deliver car have been created successfully"),
      @ApiResponse(responseCode = "404", description = "Reservation not Found!"),
      @ApiResponse(responseCode = "500", description = "Server Error!"),})
  @PutMapping
  ResponseEntity<ReservationDTO> deliverCarAndCalculateSurcharges(
      @RequestBody ReservationDeliverRequestParamDTO reservation);

}
