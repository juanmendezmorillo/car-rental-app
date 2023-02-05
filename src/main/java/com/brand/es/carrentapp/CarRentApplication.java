package com.brand.es.carrentapp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "API Car Rental"))
@SpringBootApplication
public class CarRentApplication {

  public static void main(String[] args) {
    SpringApplication.run(CarRentApplication.class, args);
  }
}
