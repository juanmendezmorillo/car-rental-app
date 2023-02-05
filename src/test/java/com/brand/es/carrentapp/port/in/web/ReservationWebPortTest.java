package com.brand.es.carrentapp.port.in.web;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

import com.brand.es.carrentapp.CarRentApplication;
import com.brand.es.carrentapp.application.dto.ReservationCreateRequestParamDTO;
import com.brand.es.carrentapp.application.dto.ReservationDeliverRequestParamDTO;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = RANDOM_PORT, classes = CarRentApplication.class)
@DisplayName("Reservation Web Port Tests")
@Tag("IntegrationTest")
public class ReservationWebPortTest {

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  @DisplayName("when GET Reservation, then returns 403")
  public void whenGetReservation_thenReturns403() {

    //when
    ResponseEntity<String> responseEntity = restTemplate.getForEntity("/reservation", String.class);

    //then
    assertEquals(NOT_FOUND, responseEntity.getStatusCode());
    assertNotNull(responseEntity.getBody());
    assertFalse(responseEntity.getBody().isEmpty());
  }

  @Test
  @DisplayName("when POST Reservation, then returns 200")
  public void whenPostReservation_thenReturns200() {

    ReservationCreateRequestParamDTO reservationCreateRequestParamDTO =
        ReservationCreateRequestParamDTO
            .builder()
            .carId(1L)
            .userId(1L)
            .pickUpTime(LocalDateTime.parse("2023-02-05T15:56:25"))
            .returnTime(LocalDateTime.parse("2023-02-06T15:56:25"))
            .build();

    List<ReservationCreateRequestParamDTO> listReservationCreateRequestParamDTO
        = new ArrayList<>();
    listReservationCreateRequestParamDTO.add(reservationCreateRequestParamDTO);

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    HttpEntity<List> entity =
        new HttpEntity<List>(listReservationCreateRequestParamDTO, headers);

    //when
    ResponseEntity<String> responseEntity =
        restTemplate.exchange("/reservation", HttpMethod.POST, entity, String.class);

    //then
    assertEquals(OK, responseEntity.getStatusCode());
    assertNotNull(responseEntity.getBody());
    assertFalse(responseEntity.getBody().isEmpty());
  }

  @Test
  @DisplayName("when PUT Reservation, then returns 403")
  public void whenPutReservation_thenReturns403() {

    ReservationDeliverRequestParamDTO reservationDeliverRequestParamDTO =
        ReservationDeliverRequestParamDTO
            .builder()
            .id(1L)
            .returnTimeReal(LocalDateTime.parse("2023-02-05T15:56:25"))
            .build();

    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

    HttpEntity<ReservationDeliverRequestParamDTO> entity =
        new HttpEntity<ReservationDeliverRequestParamDTO>(reservationDeliverRequestParamDTO,
            headers);

    //when
    ResponseEntity<String> responseEntity =
        restTemplate.exchange("/reservation", HttpMethod.PUT, entity, String.class);

    //then
    assertEquals(NOT_FOUND, responseEntity.getStatusCode());
    assertNotNull(responseEntity.getBody());
    assertFalse(responseEntity.getBody().isEmpty());
  }

}
