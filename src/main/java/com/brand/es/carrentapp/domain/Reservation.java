package com.brand.es.carrentapp.domain;

import com.brand.es.carrentapp.domain.enumerated.ReservationStatusEnum;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation implements Serializable {

  private Long id;
  private Car carId;
  private User userId;
  private LocalDateTime pickUpTime;
  private LocalDateTime returnTime;
  private LocalDateTime returnTimeReal;
  private Double totalPrice;
  private Double totalPriceExtra;
  private Integer loyaltyPoints;
  private ReservationStatusEnum status;

  public long calculateDays() {
    return ChronoUnit.DAYS.between(this.pickUpTime, this.returnTime);
  }

  public long calculateExtraDays() {
    return ChronoUnit.DAYS.between(this.returnTime, this.returnTimeReal);
  }

}