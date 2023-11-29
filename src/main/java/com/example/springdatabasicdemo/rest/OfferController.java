//package com.example.springdatabasicdemo.rest;
//
//import com.example.springdatabasicdemo.exeptions.OfferNotFoundExeption;
//import com.example.springdatabasicdemo.services.OfferService;
//import com.example.springdatabasicdemo.services.dtos.OfferDto;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//import java.util.UUID;
//
//@RestController
//@RequestMapping("/offers")
//public class OfferController {
//
//    private OfferService offerService;
//
//    public OfferController() {}
//
//    @GetMapping("/all")
//    Iterable<OfferDto> all() {
//        return offerService.getAll();
//    }
//
//    @GetMapping("/{id}")
//    Optional<OfferDto> get(@PathVariable UUID id) {
//        return Optional.ofNullable(offerService.find((id)).orElseThrow(() -> new OfferNotFoundExeption(id)));
//    }
//
//    @DeleteMapping("/{id}")
//    void delete(@PathVariable UUID id) {
//        offerService.destroyById(id);
//    }
//
//    @PutMapping("/update")
//    OfferDto update(@RequestBody OfferDto offer) {
//        return offerService.create(offer);
//    }
//
//    @PostMapping("/add")
//    void add(@RequestBody OfferDto offer) {
//        offerService.addOffer(offer);
//    }
//
//    @Autowired
//    public void setOfferService(OfferService offerService) {
//        this.offerService = offerService;
//    }
//}
