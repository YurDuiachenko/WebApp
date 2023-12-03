package com.example.springdatabasicdemo.web;

import com.example.springdatabasicdemo.dtos.brand.BrandDto;
import com.example.springdatabasicdemo.exeptions.BrandNotFoundExeption;
import com.example.springdatabasicdemo.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/brands")
public class BrandController {

//    @Autowired
    private BrandService brandService;

    public BrandController() {}

    @GetMapping("/all")
    public String all(Model model) {
        model.addAttribute("allBrand", brandService.getAll());

        return "pages-brand/brand-all";
    }

    @GetMapping("/{id}")
    Optional<BrandDto> get(@PathVariable UUID id) {
        return Optional.ofNullable(brandService.find((id)).orElseThrow(() -> new BrandNotFoundExeption(id)));
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable UUID id) {
        brandService.destroyById(id);
    }

    @PutMapping("/update")
    BrandDto update(@RequestBody BrandDto brand) {
        return brandService.create(brand);
    }

    @PostMapping("/add")
    void add(@RequestBody BrandDto brand) {
        brandService.addBrand(brand);
    }

    @Autowired
    public void setBrandService(BrandService brandService) {
        this.brandService = brandService;
    }
}
