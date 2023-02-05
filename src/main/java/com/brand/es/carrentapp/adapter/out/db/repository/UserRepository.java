package com.brand.es.carrentapp.adapter.out.db.repository;

import com.brand.es.carrentapp.adapter.out.db.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
