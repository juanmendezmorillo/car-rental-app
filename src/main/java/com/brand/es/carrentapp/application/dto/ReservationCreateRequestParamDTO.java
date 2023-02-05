package com.brand.es.carrentapp.application.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationCreateRequestParamDTO {

  @Schema(name = "Car id", required = true)
  @JsonProperty("Car id")
  private Long carId;
  @Schema(name = "User id", required = true)
  @JsonProperty("User id")
  private Long userId;
  @Schema(name = "Pick up time", required = true)
  @JsonProperty("Pick up time")
  private LocalDateTime pickUpTime;
  @Schema(name = "Return time", required = true)
  @JsonProperty("Return time")
  private LocalDateTime returnTime;

}
