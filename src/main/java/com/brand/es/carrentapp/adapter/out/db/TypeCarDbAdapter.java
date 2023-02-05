package com.brand.es.carrentapp.adapter.out.db;

import com.brand.es.carrentapp.adapter.out.db.repository.TypeCarRepository;
import com.brand.es.carrentapp.application.dto.TypeCarDTO;
import com.brand.es.carrentapp.port.out.db.TypeCarDbPort;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TypeCarDbAdapter implements TypeCarDbPort {

  private TypeCarRepository typeCarRepository;
  private ModelMapper modelMapper;

  @Override
  public Optional<List<TypeCarDTO>> findAll() {
    return Optional.of(
        typeCarRepository.findAll()
            .stream()
            .map(typeCarEntity -> modelMapper.map(typeCarEntity, TypeCarDTO.class))
            .collect(Collectors.toList())
    );
  }
}
