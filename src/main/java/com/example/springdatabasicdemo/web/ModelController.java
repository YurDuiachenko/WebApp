package com.example.springdatabasicdemo.web;

import com.example.springdatabasicdemo.dtos.car.AddCarDto;
import com.example.springdatabasicdemo.dtos.car.ModelDto;
import com.example.springdatabasicdemo.exeptions.ModelNotFoundExeption;
import com.example.springdatabasicdemo.repositories.ModelRepository;
import com.example.springdatabasicdemo.services.BrandService;
import com.example.springdatabasicdemo.services.ModelService;
import jakarta.validation.Valid;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.Optional;
import java.util.UUID;

//@RestController
@Controller
@RequestMapping("/models")
public class ModelController {

//    @Autowired
    private ModelService modelService;
    private ModelRepository modelRepository;
    private BrandService brandService;
    private final ModelMapper modelMapper;
    private static final Logger LOG = LogManager.getLogger(Controller.class);

    public ModelController(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    public String all(Model model, Principal principal) {
        LOG.log(Level.INFO, "Show all models for - " + principal.getName());
        model.addAttribute("models", modelService.getAll());

        return "models-all";
    }

    @GetMapping("/{id}")
    public Optional<ModelDto> get(@PathVariable UUID id) {
        return Optional.ofNullable(modelService.find((id)).orElseThrow(() -> new ModelNotFoundExeption(id)));
    }

    @GetMapping("/model-details/{model-name}")
    public String carDetails(@PathVariable("model-name") String modelName, Model model, Principal principal) {
        LOG.log(Level.INFO, "Show details of" + modelName + " for " + principal.getName());
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
    public String addCar(Model model) {
        model.addAttribute("brands", brandService.getAll());
        return "models-add";
    }

    @GetMapping("/model-delete/{model-name}")
    public String deleteCar(@PathVariable("model-name") String modelName, Principal principal) {
        LOG.log(Level.INFO,  principal.getName() + " deleted " + modelName);
        modelService.destroyById(modelRepository.findByName(modelName).get().id);

        return "redirect:/models/all";
    }

    @ModelAttribute("carModel")
    public AddCarDto init(){
        return new AddCarDto();
    }

    @PostMapping("/add")
    public String addCar(@Valid AddCarDto carModel,
        BindingResult bindingResult,
        RedirectAttributes redirectAttributes,
        Principal principal) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("carModel", carModel);
            redirectAttributes
                .addFlashAttribute("org.springframework.validation.BindingResult.carModel",
                bindingResult);
            return "redirect:/models/add";
        }
        modelService.addModel(carModel);
        LOG.log(Level.INFO,  principal.getName() + " add new car: " + carModel.getName());
        return "redirect:/models/all";
    }

    @GetMapping("/update/{modelName}")
    public String updateModel(@PathVariable("modelName") String modelName, Model model, Principal principal) {

        com.example.springdatabasicdemo.models.Model modela = modelRepository.findByName(modelName).get();
        model.addAttribute("model", modela);
        model.addAttribute("brands", brandService.getAll());
        model.addAttribute("updateModel", modelMapper.map(modela, AddCarDto.class));
        LOG.log(Level.INFO,  principal.getName() + " updated new car: " + modelName);
        return "model-update";
    }

    @PostMapping("/update/{modelName}")
    public String updateModel(@PathVariable("modelName") String modelName, @Valid AddCarDto addCarDto,
        BindingResult bindingResult, RedirectAttributes redirectAttributes) {
//        if (bindingResult.hasErrors()) {
//            redirectAttributes.addFlashAttribute("updateUserModel", addCarDto);
//            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.updateUserModel",
//                bindingResult);
//            return "redirect:/models/update/" + modelName;
//        }
        modelService.addModel(addCarDto);
//        modelService.updateModel(modelName, addCarDto);
        return "redirect:/models/all";
    }

    @Autowired
    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }

    @Autowired
    public void setBrandService(BrandService brandService) {
        this.brandService = brandService;
    }

    @Autowired
    public void setModelRepository(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

}
