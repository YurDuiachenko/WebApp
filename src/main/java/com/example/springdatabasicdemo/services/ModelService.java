package com.example.springdatabasicdemo.services;


import com.example.springdatabasicdemo.dtos.car.AddCarDto;
import com.example.springdatabasicdemo.dtos.car.CarDetailsDto;
import com.example.springdatabasicdemo.dtos.car.ModelDto;
import com.example.springdatabasicdemo.dtos.car.ShowAllCarsDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface ModelService {
    ModelDto create(ModelDto t);

    void addModel(AddCarDto addCarDto);

    void destroy(ModelDto t);

    void destroyById(UUID id);

    Optional<ModelDto> find(UUID id);

    List<ShowAllCarsDto> getAll();

    CarDetailsDto modelDetails(String name);
}
