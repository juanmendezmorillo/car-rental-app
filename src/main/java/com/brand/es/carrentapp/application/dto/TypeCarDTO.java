package com.brand.es.carrentapp.application.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "TypeCar")
public class TypeCarDTO implements Serializable {

  @Schema(hidden = true)
  @JsonIgnore
  private Long id;
  @Schema(name = "Category")
  @JsonProperty("Category")
  private String category;
  @Schema(name = "Price per day")
  @JsonProperty("Price per day")
  private Double pricePerDay;
  @Schema(name = "Loyalty points")
  @JsonProperty("Loyalty points")
  private Integer loyaltyPoints;
}
