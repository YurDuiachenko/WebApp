package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.car.*;
import com.example.springdatabasicdemo.models.Brand;
import com.example.springdatabasicdemo.models.Model;
import com.example.springdatabasicdemo.repositories.BrandRepository;
import com.example.springdatabasicdemo.repositories.ModelRepository;
import com.example.springdatabasicdemo.repositories.OfferRepository;
import com.example.springdatabasicdemo.services.ModelService;
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
public class ModelServiceImpl implements ModelService {

    private ModelRepository modelRepository;
    private BrandRepository brandRepository;

    private final OfferRepository offerRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public ModelServiceImpl(OfferRepository offerRepository, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public ModelDto create(ModelDto modelDto) {
        Model s = modelMapper.map(modelDto, Model.class);
        return modelMapper.map(modelRepository.save(s), ModelDto.class);
    }

    @Override
    public void addModel(AddCarDto addCarDto) {
        if (!this.validationUtil.isValid(addCarDto)) {

            this.validationUtil
                .violations(addCarDto)
                .stream()
                .map(ConstraintViolation::getMessage)
                .forEach(System.out::println);

            throw new IllegalArgumentException("Illegal arguments!");
        }

        Model model = this.modelMapper.map(addCarDto, Model.class);
        Brand brand = brandRepository.findByName(addCarDto.getBrandName());
        brand = brandRepository.save(brand);
        model.setBrand(brand);

        this.modelRepository.saveAndFlush(model);

    }

    @Override
    public void updateModel(String modelName, AddCarDto addCarDto) {
        Model model = modelRepository.findByName(modelName).get();
        model = (modelMapper.map(addCarDto, Model.class));
        modelRepository.saveAndFlush(model);
    }

    @Override
    public void destroy(ModelDto modelDto) {
        modelRepository.deleteById(modelDto.id());
    }

    @Override
    public void destroyById(UUID id) {
        modelRepository.deleteById(id);
    }

    @Override
    public Optional<ModelDto> find(UUID id) {
        return Optional.ofNullable(modelMapper.map(modelRepository.findById(id), ModelDto.class));
    }

    @Override
    public List<ShowAllCarsDto> getAll() {
        return modelRepository.findAll()
            .stream()
            .map(
                (s) -> modelMapper
                    .map(s, ShowAllCarsDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public CarDetailsDto modelDetails(String name) {
        return modelMapper.map(modelRepository.findByName(name).orElse(null), CarDetailsDto.class);
    }

    @Override
    public List<ModelWithPriceDto> findAllByBrand(String name) {
        return modelRepository.findAllByBrand(brandRepository.findByName(name))
            .stream()
            .map(
                (s) -> modelMapper.map(s, ModelWithPriceDto.class))
            .collect(Collectors.toList());
    }

    @Autowired
    public void setModelRepository(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Autowired
    public void setBrandRepository(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }
}
