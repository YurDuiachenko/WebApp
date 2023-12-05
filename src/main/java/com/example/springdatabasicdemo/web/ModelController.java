package com.example.springdatabasicdemo.web;

import com.example.springdatabasicdemo.dtos.car.AddCarDto;
import com.example.springdatabasicdemo.dtos.car.ModelDto;
import com.example.springdatabasicdemo.exeptions.ModelNotFoundExeption;
import com.example.springdatabasicdemo.services.ModelService;
import jakarta.validation.Valid;
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
public class ModelController {

//    @Autowired
    private ModelService modelService;

    public ModelController() {}

    @GetMapping("/all")
    public String all(Model model) {
        model.addAttribute("models", modelService.getAll());

        return "models-all";
    }

    @GetMapping("/{id}")
    public Optional<ModelDto> get(@PathVariable UUID id) {
        return Optional.ofNullable(modelService.find((id)).orElseThrow(() -> new ModelNotFoundExeption(id)));
    }

    @GetMapping("/model-details/{model-name}")
    public String carDetails(@PathVariable("model-name") String modelName, Model model) {
        model.addAttribute("carDetails", modelService.modelDetails(modelName));

        return "models-details";
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        modelService.destroyById(id);
    }

    @PutMapping("/update")
    public ModelDto update(@RequestBody ModelDto model) {
        return modelService.create(model);
    }

    @GetMapping("/add")
    public String addCar() {
        return "models-add";
    }
    @ModelAttribute("carModel")
    public ModelDto init(){
        return new ModelDto();
    }

    @PostMapping("/add")
    public String addCar(@Valid AddCarDto carModel,
        BindingResult bindingResult,
        RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("carModel", carModel);
            redirectAttributes
                .addFlashAttribute("org.springframework.validation.BindingResult.carModel",
                bindingResult);
            return "redirect:/models/add";
        }
        modelService.addModel(carModel);

        return "redirect:/";
    }

    @Autowired
    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }
}
