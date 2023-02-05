package com.brand.es.carrentapp;

import com.brand.es.carrentapp.adapter.out.db.model.UserEntity;
import com.brand.es.carrentapp.application.dto.UserDTO;
import com.brand.es.carrentapp.domain.CarRental;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

  @Bean
  public ModelMapper modelMapper() {

    ModelMapper modelMapper = new ModelMapper();
    PropertyMap<UserEntity, UserDTO> skipModifiedFieldsMap =
        // problems performing mapper, 'reservations' attribute
        // goes into setter loop since attribute has 'userId' field mapped
        new PropertyMap<UserEntity, UserDTO>() {
          protected void configure() {
            skip().setReservations(null);
          }
        };
    modelMapper.addMappings(skipModifiedFieldsMap);

    return modelMapper;
  }

  @Bean
  public CarRental carRental() {
    return new CarRental();
  }

}
