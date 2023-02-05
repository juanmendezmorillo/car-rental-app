package com.brand.es.carrentapp.adapter.out.db.repository;

import com.brand.es.carrentapp.adapter.out.db.model.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {

}
