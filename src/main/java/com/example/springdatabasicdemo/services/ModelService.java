package com.example.springdatabasicdemo.services;


import com.example.springdatabasicdemo.dtos.car.*;
import com.example.springdatabasicdemo.models.Model;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface ModelService {
    ModelDto create(ModelDto t);

    void addModel(AddCarDto addCarDto);

    void updateModel(String modelName, AddCarDto addCarDto);

    void destroy(ModelDto t);

    void destroyById(UUID id);

    Optional<ModelDto> find(UUID id);

    List<ShowAllCarsDto> getAll();

    CarDetailsDto modelDetails(String name);

    List<ModelWithPriceDto> findAllByBrand(String name);

    ModelDto map(Model model);
}
