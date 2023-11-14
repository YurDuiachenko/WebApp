package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.services.dtos.BrandDto;
import com.example.springdatabasicdemo.models.Brand;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BrandService{
    BrandDto create(BrandDto t);

    void addBrand(BrandDto brandDto);

    Brand findByName(String name);

    void destroy(BrandDto t);

    void destroyById(UUID id);

    Optional<BrandDto> find(UUID id);

    List<BrandDto> getAll();
}
