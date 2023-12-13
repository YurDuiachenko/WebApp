package com.example.springdatabasicdemo.web;

import com.example.springdatabasicdemo.dtos.car.AddCarDto;
import com.example.springdatabasicdemo.dtos.car.ModelDto;
import com.example.springdatabasicdemo.dtos.offer.AddOfferDto;
import com.example.springdatabasicdemo.dtos.offer.OfferDto;
import com.example.springdatabasicdemo.exeptions.OfferNotFoundExeption;
import com.example.springdatabasicdemo.repositories.ModelRepository;
import com.example.springdatabasicdemo.services.ModelService;
import com.example.springdatabasicdemo.services.OfferService;
import com.example.springdatabasicdemo.services.UsersService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/offers")
public class OfferController {
    private OfferService offerService;
    private UsersService usersService;
    private ModelService modelService;
    private ModelRepository modelRepository;
    private static final Logger LOG = LogManager.getLogger(Controller.class);

    public OfferController() {}

    @GetMapping("/all")
    public String all(Model model, Principal principal) {
        LOG.log(Level.INFO, "Show all offers for - " + principal.getName());
        model.addAttribute("offers", offerService.getAll());

        return "offer-all";
    }

    @GetMapping("/offer-details/{offer-id}")
    public String carDetails(@PathVariable("offer-id") UUID offerId, Model model, Principal principal) {
        LOG.log(Level.INFO, "Show all offers for - " + principal.getName());
        model.addAttribute("offerDetails", offerService.offerDetails(offerId));

        return "offer-details";
    }


    @GetMapping("/add/{model-name}")
    public String addOffer(@PathVariable("model-name") String modelName, Model model) {
        init(modelService.map(modelRepository.findByName(modelName).get()));
        model.addAttribute("users", usersService.getAll());
        return "offer-add";
    }

    @ModelAttribute("offerModel")
    public AddOfferDto init(ModelDto model){
        return new AddOfferDto(model);
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
    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }
    @Autowired
    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }
    @Autowired
    public void setModelRepository(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

}
