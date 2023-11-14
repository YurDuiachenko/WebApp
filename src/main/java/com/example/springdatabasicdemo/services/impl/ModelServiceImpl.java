package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.services.dtos.ModelDto;
import com.example.springdatabasicdemo.models.Brand;
import com.example.springdatabasicdemo.models.Model;
import com.example.springdatabasicdemo.repositories.ModelRepository;
import com.example.springdatabasicdemo.services.BrandService;
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
    private BrandService brandService;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public ModelServiceImpl(ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public ModelDto create(ModelDto modelDto) {
        Model s = modelMapper.map(modelDto, Model.class);
        return modelMapper.map(modelRepository.save(s), ModelDto.class);
    }

    @Override
    public void addModel(ModelDto modelDto) {
        if (!this.validationUtil.isValid(modelDto)) {

            this.validationUtil
                .violations(modelDto)
                .stream()
                .map(ConstraintViolation::getMessage)
                .forEach(System.out::println);

            throw new IllegalArgumentException("Illegal arguments!");
        }

        Model model = this.modelMapper.map(modelDto, Model.class);
        model.setBrand(modelMapper.map(brandService.create(modelDto.getBrand()), Brand.class));

        this.modelRepository.saveAndFlush(model);

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
    public List<ModelDto> getAll() {
        return modelRepository.findAll().stream().map((s) -> modelMapper.map(s, ModelDto.class)).collect(Collectors.toList());
    }

    @Autowired
    public void setModelRepository(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Autowired
    public void setBrandRepository(BrandService brandService) {
        this.brandService = brandService;
    }
}
