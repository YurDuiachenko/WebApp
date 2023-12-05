package com.example.springdatabasicdemo.config;

import com.example.springdatabasicdemo.constants.Category;
import com.example.springdatabasicdemo.constants.Engine;
import com.example.springdatabasicdemo.constants.Role;
import com.example.springdatabasicdemo.constants.Transmission;
import com.example.springdatabasicdemo.dtos.brand.BrandDto;
import com.example.springdatabasicdemo.dtos.car.ModelDto;
import com.example.springdatabasicdemo.dtos.offer.OfferDto;
import com.example.springdatabasicdemo.dtos.role.UserRoleDto;
import com.example.springdatabasicdemo.dtos.user.UserDto;
import com.example.springdatabasicdemo.services.*;
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

        UserRoleDto role = new UserRoleDto(Role.ADMIN);
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
                Category.CAR,
                "https://source.unsplash.com/random/200x200?sig=1",
                2010,
                2011,
                new Date(),
                new Date(),
                brand
        );
        model = modelService.create(model);

        BrandDto brand1 = new BrandDto(
            "Honda",
            new Date(),
            new Date()
        );
        brand1 = brandService.create(brand1);

        BrandDto brand2 = new BrandDto(
            "Ford",
            new Date(),
            new Date()
        );
        brand2 = brandService.create(brand2);

        BrandDto brand3 = new BrandDto(
            "Toyota",
            new Date(),
            new Date()
        );
        brand3 = brandService.create(brand3);

        BrandDto brand4 = new BrandDto(
            "Mercedes",
            new Date(),
            new Date()
        );
        brand4 = brandService.create(brand4);

        ModelDto model1 = new ModelDto(
            "Civic",
            Category.CAR,
            "https://source.unsplash.com/random/200x200?sig=2",
            2010,
            2011,
            new Date(),
            new Date(),
            brand3
        );

        ModelDto model2 = new ModelDto(
            "Impala",
            Category.CAR,
            "https://source.unsplash.com/random/200x200?sig=3",
            2010,
            2011,
            new Date(),
            new Date(),
            brand
        );

        ModelDto model3 = new ModelDto(
            "Integra",
            Category.CAR,
            "https://source.unsplash.com/random/200x200?sig=4",
            2010,
            2011,
            new Date(),
            new Date(),
            brand3
        );

        ModelDto model4 = new ModelDto(
            "Accord",
            Category.CAR,
            "https://source.unsplash.com/random/200x200?sig=5",
            2010,
            2011,
            new Date(),
            new Date(),
            brand3
        );

        ModelDto model5 = new ModelDto(
            "Camaro",
            Category.CAR,
            "https://source.unsplash.com/random/200x200?sig=6",
            2010,
            2011,
            new Date(),
            new Date(),
            brand
        );
        modelService.create(model1);
        modelService.create(model2);
        modelService.create(model3);
        modelService.create(model4);
        modelService.create(model5);

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

