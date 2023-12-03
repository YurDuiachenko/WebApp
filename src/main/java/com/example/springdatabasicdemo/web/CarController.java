package com.example.springdatabasicdemo.web;

import com.example.springdatabasicdemo.dtos.car.ModelDto;
import com.example.springdatabasicdemo.exeptions.ModelNotFoundExeption;
import com.example.springdatabasicdemo.services.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;
import java.util.UUID;

//@RestController
@Controller
@RequestMapping("/models")
public class CarController {

//    @Autowired
    private ModelService modelService;

    public CarController() {}

    @GetMapping("/all")
    public String all(Model model) {
        model.addAttribute("models", modelService.getAll());

        return "car-all";
    }

    @GetMapping("/{id}")
    public Optional<ModelDto> get(@PathVariable UUID id) {
        return Optional.ofNullable(modelService.find((id)).orElseThrow(() -> new ModelNotFoundExeption(id)));
    }

    @GetMapping("/model-details/{model-name}")
    public String carDetails(@PathVariable("model-name") String modelName, Model model) {
        model.addAttribute("carDetails", modelService.modelDetails(modelName));

        return "car-details";
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        modelService.destroyById(id);
    }

    @PutMapping("/update")
    public ModelDto update(@RequestBody ModelDto model) {
        return modelService.create(model);
    }

//    @PostMapping("/add")
//    public void add(@RequestBody ModelDto model) {
//        modelService.addModel(model);
//    }
    @PostMapping("/add")
    public String addCompany(ModelDto modelDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("modelDto", modelDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.companyModel",
                bindingResult);
            return "redirect:/models/add";
        }
        modelService.addModel(modelDto);

        return "redirect:/";
    }

    @Autowired
    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }
}
