package com.example.springdatabasicdemo.web;

import com.example.springdatabasicdemo.services.ModelService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final ModelService modelService;
    private static final Logger LOG = LogManager.getLogger(Controller.class);

    public HomeController(ModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping("/homepage")
    public String homePage(Model model) {
        LOG.log(Level.INFO, "Show homepage for - ");
        var models = modelService.findAllByBrand("Chevrolet");
        model.addAttribute("models", models);
        return "index";
    }
}
