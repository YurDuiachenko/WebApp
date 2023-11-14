package com.example.springdatabasicdemo.controllers;

import com.example.springdatabasicdemo.services.dtos.BrandDto;
import com.example.springdatabasicdemo.exeptions.BrandNotFoundExeption;
import com.example.springdatabasicdemo.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
//@RequestMapping("/brands")
public class BrandController {

//    @Autowired
    private BrandService brandService;

    public BrandController() {}

    @GetMapping("/brands")
    Iterable<BrandDto> all() {
        return brandService.getAll();
    }

    @GetMapping("/brands/{id}")
    Optional<BrandDto> get(@PathVariable UUID id) {
        return Optional.ofNullable(brandService.find((id)).orElseThrow(() -> new BrandNotFoundExeption(id)));
    }

    @DeleteMapping("/brands/{id}")
    void delete(@PathVariable UUID id) {
        brandService.destroyById(id);
    }

    @PutMapping("/brands")
    BrandDto update(@RequestBody BrandDto brand) {
        return brandService.create(brand);
    }

    @PostMapping("/brands")
    void add(@RequestBody BrandDto brand) {
        brandService.addBrand(brand);
    }

    @Autowired
    public void setBrandService(BrandService brandService) {
        this.brandService = brandService;
    }
}
