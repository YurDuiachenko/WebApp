package com.example.springdatabasicdemo.services;


import com.example.springdatabasicdemo.services.dtos.ModelDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface ModelService {
    ModelDto create(ModelDto t);

    void addModel(ModelDto modelDto);

    void destroy(ModelDto t);

    void destroyById(UUID id);

    Optional<ModelDto> find(UUID id);

    List<ModelDto> getAll();
}
