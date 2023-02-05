package com.brand.es.carrentapp.adapter.out.db;

import com.brand.es.carrentapp.adapter.out.db.model.ReservationEntity;
import com.brand.es.carrentapp.adapter.out.db.repository.ReservationRepository;
import com.brand.es.carrentapp.adapter.out.db.repository.UserRepository;
import com.brand.es.carrentapp.application.dto.UserDTO;
import com.brand.es.carrentapp.port.out.db.UserDbPort;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserDbAdapter implements UserDbPort {

  private UserRepository userRepository;
  private ReservationRepository reservationRepository;
  private ModelMapper modelMapper;


  @Override
  public Optional<UserDTO> findById(Long id) {

    return userRepository
        .findById(id)
        .map(userEntity -> {
          UserDTO userDTO = modelMapper.map(userEntity, UserDTO.class);
          userDTO.setTotalLoyaltyPoints(
              userEntity.getReservations()
                  .stream()
                  .mapToInt(ReservationEntity::getLoyaltyPoints)
                  .sum()
          );
          return userDTO;
        });
  }

  @Override
  public Optional<List<UserDTO>> findAll() {
    return Optional.of(
        userRepository.findAll()
            .stream()
            .map(userEntity -> {
              UserDTO userDTO = modelMapper.map(userEntity, UserDTO.class);
              userDTO.setTotalLoyaltyPoints(
                  userEntity.getReservations()
                      .stream()
                      .mapToInt(ReservationEntity::getLoyaltyPoints)
                      .sum()
              );
              return userDTO;
            })
            .collect(Collectors.toList())
    );
  }
}
