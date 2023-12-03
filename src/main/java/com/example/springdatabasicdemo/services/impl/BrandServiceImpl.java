package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.brand.BrandDto;
import com.example.springdatabasicdemo.models.Brand;
import com.example.springdatabasicdemo.repositories.BrandRepository;
import com.example.springdatabasicdemo.services.BrandService;
import com.example.springdatabasicdemo.util.ValidationUtil;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
public class BrandServiceImpl implements BrandService {

    private BrandRepository brandRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;


    public BrandServiceImpl(ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public BrandDto create(BrandDto brandDto) {
        Brand s = modelMapper.map(brandDto, Brand.class);
        return modelMapper.map(brandRepository.save(s), BrandDto.class);
    }

    @Override
    public void addBrand(BrandDto brandDto) {
        if (!this.validationUtil.isValid(brandDto)) {

            this.validationUtil
                .violations(brandDto)
                .stream()
                .map(ConstraintViolation::getMessage)
                .forEach(System.out::println);

            throw new IllegalArgumentException("Illegal arguments!");
        }
        else {
            try {
                this.brandRepository
                    .saveAndFlush(this.modelMapper.map(brandDto, Brand.class));
            } catch (Exception e) {
                System.out.println("Something went wrong!");
            }
        }

    }

    @Override
    public Brand findByName(String name) {
        return this.brandRepository.findByName(name);
    }

    @Override
    public void destroy(BrandDto brandDto) {
        brandRepository.deleteById(brandDto.id());
    }

    @Override
    public void destroyById(UUID id) {
        brandRepository.deleteById(id);
    }

    @Override
    public Optional<BrandDto> find(UUID id) {
        return Optional.ofNullable(modelMapper.map(brandRepository.findById(id), BrandDto.class));
    }

    @Override
    public List<BrandDto> getAll() {
        return brandRepository.findAll().stream().map((s) -> modelMapper.map(s, BrandDto.class)).collect(Collectors.toList());
    }

    @Autowired
    public void setBrandRepository(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }
}
