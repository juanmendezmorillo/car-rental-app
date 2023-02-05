package com.brand.es.carrentapp.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Car implements Serializable {

  private Long id;
  private String model;
  private TypeCar type;
}
