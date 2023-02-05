package com.brand.es.carrentapp.port.in.web;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpStatus.OK;

import com.brand.es.carrentapp.CarRentApplication;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = RANDOM_PORT, classes = CarRentApplication.class)
@DisplayName("Car Web Port Tests")
@Tag("IntegrationTest")
public class CarWebPortTest {

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  @DisplayName("when GET Car, then returns 200")
  public void whenGetCar_thenReturns200() {

    //when
    ResponseEntity<String> responseEntity = restTemplate.getForEntity("/car", String.class);

    //then
    assertEquals(OK, responseEntity.getStatusCode());
    assertNotNull(responseEntity.getBody());
    assertFalse(responseEntity.getBody().isEmpty());
  }

}
