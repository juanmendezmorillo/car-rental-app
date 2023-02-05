package com.brand.es.carrentapp.adapter.out.db.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "type_car")
public class TypeCarEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull(message = "Please enter the category")
  @Column(nullable = false)
  private String category;

  @NotNull(message = "Please enter the price per day")
  @Column(nullable = false)
  private Double pricePerDay;

  @NotNull(message = "Please enter the loyalty points")
  @Column(nullable = false)
  private Integer loyaltyPoints;
}
