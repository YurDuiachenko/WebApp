//package com.example.springdatabasicdemo.rest;
//
//import com.example.springdatabasicdemo.exeptions.ModelNotFoundExeption;
//import com.example.springdatabasicdemo.services.ModelService;
//import com.example.springdatabasicdemo.services.dtos.ModelDto;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//import java.util.UUID;
//
////@RestController
//@Controller
//@RequestMapping("/models")
//public class ModelController {
//
////    @Autowired
//    private ModelService modelService;
//
//    public ModelController() {}
//
//    @GetMapping("/all")
//    public Iterable<ModelDto> all(Model model) {
//        return modelService.getAll();
//    }
//
//    @GetMapping("/{id}")
//    public Optional<ModelDto> get(@PathVariable UUID id) {
//        return Optional.ofNullable(modelService.find((id)).orElseThrow(() -> new ModelNotFoundExeption(id)));
//    }
//
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable UUID id) {
//        modelService.destroyById(id);
//    }
//
//    @PutMapping("/update")
//    public ModelDto update(@RequestBody ModelDto model) {
//        return modelService.create(model);
//    }
//
//    @PostMapping("/add")
//    public void add(@RequestBody ModelDto model) {
//        modelService.addModel(model);
//    }
//
//    @Autowired
//    public void setModelService(ModelService modelService) {
//        this.modelService = modelService;
//    }
//}
