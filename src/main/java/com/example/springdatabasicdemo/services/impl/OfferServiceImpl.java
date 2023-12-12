package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.offer.OfferDetailsDto;
import com.example.springdatabasicdemo.dtos.offer.OfferDto;
import com.example.springdatabasicdemo.dtos.offer.ShowAllOffersDto;
import com.example.springdatabasicdemo.models.Model;
import com.example.springdatabasicdemo.models.Offer;
import com.example.springdatabasicdemo.models.Users;
import com.example.springdatabasicdemo.repositories.OfferRepository;
import com.example.springdatabasicdemo.services.ModelService;
import com.example.springdatabasicdemo.services.OfferService;
import com.example.springdatabasicdemo.services.UsersService;
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
public class OfferServiceImpl implements OfferService {

    private OfferRepository offerRepository;
    private ModelService modelService;
    private UsersService usersService;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public OfferServiceImpl(ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public OfferDto create(OfferDto offerDto) {
        Offer s = modelMapper.map(offerDto, Offer.class);
        return modelMapper.map(offerRepository.save(s), OfferDto.class);
    }

    @Override
    public void addOffer(OfferDto offerDto) {
        if (!this.validationUtil.isValid(offerDto)) {

            this.validationUtil
                .violations(offerDto)
                .stream()
                .map(ConstraintViolation::getMessage)
                .forEach(System.out::println);

            throw new IllegalArgumentException("Illegal arguments!");
        }

        Offer offer = this.modelMapper.map(offerDto, Offer.class);
        offer.setModel(modelMapper.map(modelService.create(offerDto.getModel()), Model.class));
        offer.setSeller(modelMapper.map(usersService.create(offerDto.getSeller()), Users.class));
        
        this.offerRepository.saveAndFlush(offer);
    }

    @Override
    public void destroy(OfferDto offerDto) {
        offerRepository.deleteById(offerDto.id());
    }

    @Override
    public void destroyById(UUID id) {
        offerRepository.deleteById(id);
    }

    @Override
    public Optional<OfferDto> find(UUID id) {
        return Optional.ofNullable(modelMapper.map(offerRepository.findById(id), OfferDto.class));
    }

    @Override
    public List<ShowAllOffersDto> getAll() {
        return offerRepository.findAll().stream().map((s) -> modelMapper.map(s, ShowAllOffersDto.class)).collect(Collectors.toList());
    }

    @Override
    public OfferDetailsDto offerDetails(UUID id) {
        return modelMapper.map(offerRepository.findById(id).orElse(null), OfferDetailsDto.class);
    }


    @Autowired
    public void setOfferRepository(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Autowired
    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }

    @Autowired
    public void setUserService(UsersService usersService) {
        this.usersService = usersService;
    }
}
