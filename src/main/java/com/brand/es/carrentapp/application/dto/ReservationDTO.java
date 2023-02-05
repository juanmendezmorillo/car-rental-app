package com.brand.es.carrentapp.application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "pickUpTime",
    "returnTime",
    "returnTimeReal",
    "totalPrice",
    "totalPriceExtra",
    "loyaltyPoints",
    "status",
    "carId",
    "userId"
})
public class ReservationDTO implements Serializable {

  @Schema(name = "Reservation id")
  @JsonProperty("Reservation id")
  private Long id;
  @Schema(name = "Car")
  @JsonProperty("Car")
  private CarDTO carId;
  @Schema(name = "User")
  @JsonProperty("User")
  private UserDTO userId;
  @Schema(name = "Pick up time")
  @JsonProperty("Pick up time")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyy HH:mm:ss")
  private LocalDateTime pickUpTime;
  @Schema(name = "Return time")
  @JsonProperty("Return time")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyy HH:mm:ss")
  private LocalDateTime returnTime;
  @Schema(name = "Return time real")
  @JsonProperty("Return time real")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyy HH:mm:ss")
  private LocalDateTime returnTimeReal;
  @Schema(name = "Total price")
  @JsonProperty("Total price")
  private Double totalPrice;
  @Schema(name = "Total price extra")
  @JsonProperty("Total price extra")
  private Double totalPriceExtra;
  @Schema(name = "Loyalty points")
  @JsonProperty("Loyalty points")
  private Integer loyaltyPoints;
  @Schema(name = "Reservation status")
  @JsonProperty("Reservation status")
  private String status;
}
