package com.example.springdatabasicdemo.config;

import com.example.springdatabasicdemo.constants.Category;
import com.example.springdatabasicdemo.constants.Engine;
import com.example.springdatabasicdemo.constants.Role;
import com.example.springdatabasicdemo.constants.Transmission;
import com.example.springdatabasicdemo.dtos.*;
import com.example.springdatabasicdemo.services.*;
import com.example.springdatabasicdemo.services.dtos.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

@Component
public class DataInitializer implements CommandLineRunner {

    
    private final UserRoleService userRoleService;
    
    private final ModelService modelService;
    
    private final UserService userService;
    
    private final BrandService brandService;
    
    private final OfferService offerService;

    public DataInitializer(
            UserRoleService userRoleService,
            ModelService modelService,
            UserService userService,
            BrandService brandService,
            OfferService offerService
    ) {
        this.userRoleService = userRoleService;
        this.modelService = modelService;
        this.userService = userService;
        this.brandService = brandService;
        this.offerService = offerService;
    }


    @Override
    public void run(String... args) throws Exception {
        seedData();
    }


    private void seedData() throws IOException {

        UserRoleDto role = new UserRoleDto(
                Role.ADMIN
        );
        role = userRoleService.create(role);

        UserDto user = new UserDto(
                "OlegTheBoss",
                "qwerty",
                "Oleg",
                "Sokolov",
                true,
                "https://source.unsplash.com/random/200x200?sig=1",
                new Date(),
                new Date(),
                role
        );
        user = userService.create(user);

        UserDto user1 = new UserDto(
                "NotMe",
                "123456",
                "Ivan",
                "Ivanov",
                true,
                "https://source.unsplash.com/random/200x200?sig=1",
                new Date(),
                new Date(),
                role
        );
        user1 = userService.create(user1);

        BrandDto brand = new BrandDto(
                "Chevrolet",
                new Date(),
                new Date()
        );
        brand = brandService.create(brand);

        ModelDto model = new ModelDto(
                "Orlando",
                Category.MOTORCYCLE,
                "https://source.unsplash.com/random/200x200?sig=1",
                2010,
                2011,
                new Date(),
                new Date(),
                brand
        );
        model = modelService.create(model);

        OfferDto offer = new OfferDto(
                "fast",
                Engine.GASOLIN,
                "https://source.unsplash.com/random/200x200?sig=1",
                100,
                25000,
                Transmission.AUTOMATIC,
                2010,
                new Date(),
                new Date(),
                model,
                user
        );

        OfferDto offer1 = new OfferDto(
                "fast",
                Engine.GASOLIN,
                "https://source.unsplash.com/random/200x200?sig=1",
                100,
                25000,
                Transmission.AUTOMATIC,
                2010,
                new Date(),
                new Date(),
                model,
                user1
        );

        System.out.println(offer);
        System.out.println(offerService.create(offer));
        System.out.println(offerService.create(offer1));
//
//        userService.destroy(user);

    }
}

