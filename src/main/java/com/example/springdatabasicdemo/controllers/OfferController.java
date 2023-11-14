package com.example.springdatabasicdemo.controllers;

import com.example.springdatabasicdemo.services.dtos.OfferDto;
import com.example.springdatabasicdemo.exeptions.OfferNotFoundExeption;
import com.example.springdatabasicdemo.services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
//@RequestMapping("/offers")
public class OfferController {

    private OfferService offerService;

    public OfferController() {}

    @GetMapping("/offers")
    Iterable<OfferDto> all() {
        return offerService.getAll();
    }

    @GetMapping("/offers/{id}")
    Optional<OfferDto> get(@PathVariable UUID id) {
        return Optional.ofNullable(offerService.find((id)).orElseThrow(() -> new OfferNotFoundExeption(id)));
    }

    @DeleteMapping("/offers/{id}")
    void delete(@PathVariable UUID id) {
        offerService.destroyById(id);
    }

    @PutMapping("/offers")
    OfferDto update(@RequestBody OfferDto offer) {
        return offerService.create(offer);
    }

    @PostMapping("/offers")
    void add(@RequestBody OfferDto offer) {
        offerService.addOffer(offer);
    }

    @Autowired
    public void setOfferService(OfferService offerService) {
        this.offerService = offerService;
    }
}
