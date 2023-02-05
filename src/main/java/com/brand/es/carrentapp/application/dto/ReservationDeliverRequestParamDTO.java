package com.brand.es.carrentapp.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDeliverRequestParamDTO {

  @Schema(name = "Reservation id", required = true)
  @JsonProperty("Reservation id")
  private Long id;
  @Schema(name = "Return time real", required = true)
  @JsonProperty("Return time real")
  private LocalDateTime returnTimeReal;
}
