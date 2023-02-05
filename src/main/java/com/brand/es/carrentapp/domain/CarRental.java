package com.brand.es.carrentapp.domain;

import com.brand.es.carrentapp.domain.enumerated.CarCategoryEnum;
import com.brand.es.carrentapp.domain.enumerated.ReservationStatusEnum;
import com.brand.es.carrentapp.domain.exception.CategoryException;
import com.brand.es.carrentapp.domain.exception.DaysReservationException;
import java.util.List;
import java.util.Optional;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
public class CarRental {

  public Optional<Reservation> calculatePriceForReservation(Reservation reservation) {
    return Optional.of(calculateTotalPrice(reservation));
  }

  private Reservation calculateTotalPrice(Reservation reservation) {

    CarCategoryEnum category = reservation.getCarId().getType().getCategory();
    Double pricePerDay = reservation.getCarId().getType().getPricePerDay();
    long daysReservation = reservation.calculateDays();
    if (daysReservation < 1L) {
      throw new DaysReservationException("Days to reserve must be greater than one");
    }
    reservation.setStatus(ReservationStatusEnum.CREATED);
    reservation.setLoyaltyPoints(reservation.getCarId().getType().getLoyaltyPoints());
    reservation.setTotalPrice(getTotalPriceByCategory(category, daysReservation, pricePerDay));

    return reservation;
  }

  private Double getTotalPriceByCategory(
      CarCategoryEnum category, long daysReservation, Double pricePerDay) {

    log.info("Car Category: " + category);
    double totalPrice;
    switch (category) {
      case PREMIUM:
        return pricePerDay * daysReservation;
      case SUV:
        if (daysReservation <= 7) {
          totalPrice = pricePerDay * daysReservation;
        } else if (daysReservation <= 30) {
          totalPrice = pricePerDay * 7; // first 7 days
          totalPrice += (pricePerDay * 0.8 * (daysReservation - 7)); // between 7 and 30 days
        } else { // daysReservation > 30
          totalPrice = pricePerDay * 7; // first 7 days
          totalPrice += (pricePerDay * 0.8 * (30 - 7)); // between 7 and 30 days
          totalPrice += (pricePerDay * 0.5 * (daysReservation - 30)); // more than 30 days
        }
        return totalPrice;
      case SMALL:
        if (daysReservation <= 7) {
          totalPrice = pricePerDay * daysReservation;
        } else { // daysReservation > 7
          totalPrice = pricePerDay * 7; // first 7 days
          totalPrice += (pricePerDay * 0.6 * (daysReservation - 7)); // more than 7 days
        }
        return totalPrice;
      default:
        log.error("Category " + category + " not found");
        throw new CategoryException("Category " + category + " not found");
    }

  }

  public Optional<Reservation> returnCarAndCalculateSurcharges(Reservation reservation,
      List<TypeCar> typeCars) {

    return Optional.of(calculateSurcharges(reservation, typeCars));
  }

  private Reservation calculateSurcharges(Reservation reservation, List<TypeCar> typeCars) {

    CarCategoryEnum category = reservation.getCarId().getType().getCategory();
    Double pricePerDay = reservation.getCarId().getType().getPricePerDay();
    long extraDays = reservation.calculateExtraDays();
    log.info("Extra days: " + extraDays);

    reservation.setStatus(ReservationStatusEnum.DONE);
    reservation.setTotalPriceExtra(0.0);
    if (extraDays > 0) {
      log.info("Car Category: " + category);
      switch (category) {
        case PREMIUM:
          reservation.setTotalPriceExtra((pricePerDay + (pricePerDay * 0.2)) * extraDays);
          return reservation;
        case SUV:
          reservation.setTotalPriceExtra(
              (pricePerDay + (getPriceSmallTypeCar(typeCars) * 0.6)) * extraDays);
          return reservation;
        case SMALL:
          reservation.setTotalPriceExtra((pricePerDay + (pricePerDay * 0.3)) * extraDays);
          return reservation;
        default:
          log.error("Category " + category + " not found");
          throw new CategoryException("Category " + category + " not found");
      }
    } else {
      return reservation;
    }
  }

  private Double getPriceSmallTypeCar(List<TypeCar> typeCars) {
    Optional<TypeCar> foundTypeCar = typeCars
        .stream()
        .filter(typeCar -> typeCar.getCategory() == CarCategoryEnum.SMALL)
        .findAny();

    if (!foundTypeCar.isPresent()) {
      log.error("Category " + CarCategoryEnum.SMALL + " in Type Cars not found");
      throw new CategoryException("Category " + CarCategoryEnum.SMALL + " in Type Cars not found");
    }
    return foundTypeCar.get().getPricePerDay();
  }

}
