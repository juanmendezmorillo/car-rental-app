package com.brand.es.carrentapp.application.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
@Schema(name = "User")
public class UserDTO implements Serializable {

  @Schema(name = "User id")
  @JsonProperty("User id")
  private Long id;
  @Schema(name = "Name")
  @JsonProperty("Name")
  private String name;
  @Schema(name = "Surnames")
  @JsonProperty("Surnames")
  private String surnames;
  @Schema(name = "Loyalty points")
  @JsonProperty("Loyalty points")
  private Integer totalLoyaltyPoints;
  @Schema(hidden = true)
  @JsonIgnore
  private List<ReservationDTO> reservations;
}
