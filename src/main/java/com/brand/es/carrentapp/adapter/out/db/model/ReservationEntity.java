package com.brand.es.carrentapp.adapter.out.db.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reservation")
public class ReservationEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne
  @JoinColumn(name = "car_id", referencedColumnName = "id")
  private CarEntity carId;

  @ManyToOne
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private UserEntity userId;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
  @NotNull(message = "Please enter the pick up time of the reservation")
  @Column(nullable = false)
  private LocalDateTime pickUpTime;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
  @NotNull(message = "Please enter the return time of the reservation")
  @Column(nullable = false)
  private LocalDateTime returnTime;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
  private LocalDateTime returnTimeReal;

  @NotNull(message = "Please enter the total price")
  @Column(nullable = false)
  private Double totalPrice;

  private Double totalPriceExtra;

  @NotNull(message = "Please enter the loyalty points")
  @Column(nullable = false)
  private Integer loyaltyPoints;

  @NotNull(message = "Please enter the status")
  @Column(nullable = false)
  private String status;
}
