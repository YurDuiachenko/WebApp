package com.example.springdatabasicdemo.web;

import com.example.springdatabasicdemo.dtos.offer.OfferDto;
import com.example.springdatabasicdemo.exeptions.OfferNotFoundExeption;
import com.example.springdatabasicdemo.services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/offers")
public class OfferController {
    private OfferService offerService;

    public OfferController() {}

    @GetMapping("/all")
    public String all(Model model) {
        model.addAttribute("offers", offerService.getAll());

        return "offer-all";
    }

    @GetMapping("/offer-details/{offer-id}")
    public String carDetails(@PathVariable("offer-id") UUID offerId, Model model) {
        model.addAttribute("offerDetails", offerService.offerDetails(offerId));

        return "offer-details";
    }

    @GetMapping("/{id}")
    Optional<OfferDto> get(@PathVariable UUID id) {
        return Optional.ofNullable(offerService.find((id)).orElseThrow(() -> new OfferNotFoundExeption(id)));
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable UUID id) {
        offerService.destroyById(id);
    }

    @PutMapping("/update")
    OfferDto update(@RequestBody OfferDto offer) {
        return offerService.create(offer);
    }

    @PostMapping("/add")
    void add(@RequestBody OfferDto offer) {
        offerService.addOffer(offer);
    }

    @Autowired
    public void setOfferService(OfferService offerService) {
        this.offerService = offerService;
    }
}
