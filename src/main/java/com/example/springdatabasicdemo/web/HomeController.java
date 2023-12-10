package com.example.springdatabasicdemo.web;

import com.example.springdatabasicdemo.repositories.OfferRepository;
import com.example.springdatabasicdemo.services.BrandService;
import com.example.springdatabasicdemo.services.ModelService;
import com.example.springdatabasicdemo.services.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final BrandService brandService;
    private final OfferService offerService;
    private final OfferRepository offerRepository;
    private final ModelService modelService;

    public HomeController(BrandService brandService, OfferService offerService, OfferRepository offerRepository, ModelService modelService) {
        this.brandService = brandService;
        this.offerService = offerService;
        this.offerRepository = offerRepository;
        this.modelService = modelService;
    }

    @GetMapping("/homepage")
    public String homePage(Model model) {
        var models = modelService.findAllByBrand("Chevrolet");
        model.addAttribute("models", models);
        return "index";
    }
}
