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
    private final UsersService usersService;
    private final BrandService brandService;
    private final OfferService offerService;

    public DataInitializer(
            UserRoleService userRoleService,
            ModelService modelService,
            UsersService usersService,
            BrandService brandService,
            OfferService offerService
    ) {
        this.userRoleService = userRoleService;
        this.modelService = modelService;
        this.usersService = usersService;
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

        UserRoleDto role1 = new UserRoleDto(Role.USER);
        role1 = userRoleService.create(role1);

        UserDto user = new UserDto(
                "OlegTheBoss",
                "qwerty",
                "Oleg",
                "Sokolov",
                true,
                "https://source.unsplash.com/random/200x200?sig=1",
                "oleg@gmail.com",
                new Date(),
                new Date(),
                role
        );
        user = usersService.create(user);

        UserDto user1 = new UserDto(
                "NotMe",
                "123456",
                "Ivan",
                "Ivanov",
                true,
                "https://source.unsplash.com/random/200x200?sig=1",
                "ivan@gmail.com",
                new Date(),
                new Date(),
                role1
        );
        user1 = usersService.create(user1);

        BrandDto brand = new BrandDto(
                "Chevrolet",
                new Date(),
                new Date()
        );
        brand = brandService.create(brand);

        ModelDto model = new ModelDto(
                "Orlando",
                Category.CAR,
                "https://avatars.mds.yandex.net/get-autoru-vos/6932162/aedd6ddc08ca6345468b8ead55625e5f/1200x900n",
            16_699.99,
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
            "https://images.caricos.com/h/honda/2016_honda_civic/images/2560x1440/2016_honda_civic_28_2560x1440.jpg",
            20_199.99,
            2010,
            2011,
            new Date(),
            new Date(),
            brand3
        );

        ModelDto model2 = new ModelDto(
            "Impala",
            Category.CAR,
            "https://kuznitsaspb.ru/wp-content/uploads/a/1/4/a14e97cc0b19372e8e0fab4d6a7ee3b6.jpeg",
            4_999.99,
            2010,
            2011,
            new Date(),
            new Date(),
            brand
        );

        ModelDto model3 = new ModelDto(
            "Integra",
            Category.CAR,
            "https://w-dog.ru/wallpapers/1/8/534995026683408/avtomobil-oboi-honda-integra-type-r-tyuning-belyj-poziciya-yaponiya-avtomobilnye-oboya-xonda-integra-belaya-peredok-krasivaya-mashina.jpg",
            13_999.99,
            2010,
            2011,
            new Date(),
            new Date(),
            brand3
        );

        ModelDto model4 = new ModelDto(
            "Accord",
            Category.CAR,
            "https://kuznitsaspb.ru/wp-content/uploads/1/4/1/14120c2cc3e82d8cbcad17bc58c0d9e0.jpeg",
            7_299.99,
            2010,
            2011,
            new Date(),
            new Date(),
            brand3
        );

        ModelDto model5 = new ModelDto(
            "Camaro",
            Category.CAR,
            "http://cdni.autocarindia.com/Galleries/20131210075934_JL_ChevCamaro-01.jpg",
            36_799.99,
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

        offerService.create(offer);
        offerService.create(offer1);
//
//        userService.destroy(user);

    }
}
