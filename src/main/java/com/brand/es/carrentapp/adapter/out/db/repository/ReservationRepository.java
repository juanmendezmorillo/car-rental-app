package com.brand.es.carrentapp.adapter.out.db.repository;

import com.brand.es.carrentapp.adapter.out.db.model.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {

}
