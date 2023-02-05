package com.brand.es.carrentapp.domain;

import com.brand.es.carrentapp.domain.enumerated.CarCategoryEnum;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TypeCar implements Serializable {

  private Long id;
  private CarCategoryEnum category;
  private Double pricePerDay;
  private Integer loyaltyPoints;
}
