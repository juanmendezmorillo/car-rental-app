package com.brand.es.carrentapp.application.dto;

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
@Schema(name = "Car")
public class CarDTO implements Serializable {

  @Schema(name = "Car id")
  @JsonProperty("Car id")
  private Long id;
  @Schema(name = "Model")
  @JsonProperty("Model")
  private String model;
  @Schema(name = "Type")
  @JsonProperty("Type")
  private TypeCarDTO type;
}
