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
import com.example.springdatabasicdemo.models.UserRole;
import com.example.springdatabasicdemo.models.Users;
import com.example.springdatabasicdemo.repositories.BrandRepository;
import com.example.springdatabasicdemo.repositories.UserRoleRepository;
import com.example.springdatabasicdemo.repositories.UsersRepository;
import com.example.springdatabasicdemo.services.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

//@Component
//public class DataInitializer implements CommandLineRunner {
//    private final UserRoleService userRoleService;
//    private final ModelService modelService;
//    private final UsersService usersService;
//    private final BrandService brandService;
//    private final OfferService offerService;
//
//    public DataInitializer(
//            UserRoleService userRoleService,
//            ModelService modelService,
//            UsersService usersService,
//            BrandService brandService,
//            OfferService offerService
//    ) {
//        this.userRoleService = userRoleService;
//        this.modelService = modelService;
//        this.usersService = usersService;
//        this.brandService = brandService;
//        this.offerService = offerService;
//    }
//
//
//    @Override
//    public void run(String... args) throws Exception {
//        seedData();
//    }
//
//    private void seedData() throws IOException {
//
//        UserRoleDto role = new UserRoleDto(Role.ADMIN);
//        role = userRoleService.create(role);
//
//        UserRoleDto role1 = new UserRoleDto(Role.USER);
//        role1 = userRoleService.create(role1);
//
//        UserDto user = new UserDto(
//                "OlegTheBoss",
//                "qwerty",
//                "Oleg",
//                "Sokolov",
//                true,
//                "https://source.unsplash.com/random/200x200?sig=1",
//                "oleg@gmail.com",
//                new Date(),
//                new Date(),
//                role
//        );
//        user = usersService.create(user);
//
//        UserDto user1 = new UserDto(
//                "NotMe",
//                "123456",
//                "Ivan",
//                "Ivanov",
//                true,
//                "https://source.unsplash.com/random/200x200?sig=1",
//                "ivan@gmail.com",
//                new Date(),
//                new Date(),
//                role1
//        );
//        user1 = usersService.create(user1);
//
//        BrandDto brand = new BrandDto(
//                "Chevrolet",
//                new Date(),
//                new Date()
//        );
//        brand = brandService.create(brand);
//
//        ModelDto model = new ModelDto(
//                "Orlando",
//                Category.CAR,
//                "https://avatars.mds.yandex.net/get-autoru-vos/6932162/aedd6ddc08ca6345468b8ead55625e5f/1200x900n",
//            16_699.99,
//                2010,
//                2011,
//                new Date(),
//                new Date(),
//                brand
//        );
//        model = modelService.create(model);
//
//        BrandDto brand1 = new BrandDto(
//            "Honda",
//            new Date(),
//            new Date()
//        );
//        brand1 = brandService.create(brand1);
//
//        BrandDto brand2 = new BrandDto(
//            "Ford",
//            new Date(),
//            new Date()
//        );
//        brand2 = brandService.create(brand2);
//
//        BrandDto brand3 = new BrandDto(
//            "Toyota",
//            new Date(),
//            new Date()
//        );
//        brand3 = brandService.create(brand3);
//
//        BrandDto brand4 = new BrandDto(
//            "Mercedes",
//            new Date(),
//            new Date()
//        );
//        brand4 = brandService.create(brand4);
//
//        ModelDto model1 = new ModelDto(
//            "Civic",
//            Category.CAR,
//            "https://images.caricos.com/h/honda/2016_honda_civic/images/2560x1440/2016_honda_civic_28_2560x1440.jpg",
//            20_199.99,
//            2010,
//            2011,
//            new Date(),
//            new Date(),
//            brand3
//        );
//
//        ModelDto model2 = new ModelDto(
//            "Impala",
//            Category.CAR,
//            "https://kuznitsaspb.ru/wp-content/uploads/a/1/4/a14e97cc0b19372e8e0fab4d6a7ee3b6.jpeg",
//            4_999.99,
//            2010,
//            2011,
//            new Date(),
//            new Date(),
//            brand
//        );
//
//        ModelDto model3 = new ModelDto(
//            "Integra",
//            Category.CAR,
//            "https://w-dog.ru/wallpapers/1/8/534995026683408/avtomobil-oboi-honda-integra-type-r-tyuning-belyj-poziciya-yaponiya-avtomobilnye-oboya-xonda-integra-belaya-peredok-krasivaya-mashina.jpg",
//            13_999.99,
//            2010,
//            2011,
//            new Date(),
//            new Date(),
//            brand3
//        );
//
//        ModelDto model4 = new ModelDto(
//            "Accord",
//            Category.CAR,
//            "https://kuznitsaspb.ru/wp-content/uploads/1/4/1/14120c2cc3e82d8cbcad17bc58c0d9e0.jpeg",
//            7_299.99,
//            2010,
//            2011,
//            new Date(),
//            new Date(),
//            brand3
//        );
//
//        ModelDto model5 = new ModelDto(
//            "Camaro",
//            Category.CAR,
//            "http://cdni.autocarindia.com/Galleries/20131210075934_JL_ChevCamaro-01.jpg",
//            36_799.99,
//            2010,
//            2011,
//            new Date(),
//            new Date(),
//            brand
//        );
//        modelService.create(model1);
//        modelService.create(model2);
//        modelService.create(model3);
//        modelService.create(model4);
//        modelService.create(model5);
//
//        OfferDto offer = new OfferDto(
//                "fast",
//                Engine.GASOLIN,
//                "https://source.unsplash.com/random/200x200?sig=1",
//                100,
//                25000,
//                Transmission.AUTOMATIC,
//                2010,
//                new Date(),
//                new Date(),
//                model,
//                user
//        );
//
//        OfferDto offer1 = new OfferDto(
//                "fast",
//                Engine.GASOLIN,
//                "https://source.unsplash.com/random/200x200?sig=1",
//                100,
//                25000,
//                Transmission.AUTOMATIC,
//                2010,
//                new Date(),
//                new Date(),
//                model,
//                user1
//        );
//
//        offerService.create(offer);
//        offerService.create(offer1);
////
////        userService.destroy(user);
//
//    }
//}
//
@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRoleService roleService;
    private final BrandService brandService;
    private final ModelService modelService;
    private final UsersService usersService;
    private final OfferService offerService;
    private final UserRoleService userRolesService;
    private final BrandRepository brandsRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRoleRepository roleRepository;
    private final String defaultPassword;
    private final UsersRepository usersRepository;

    public DataInitializer(UserRoleService roleService, BrandService brandService, ModelService modelService, UsersService usersService, OfferService offerService, UserRoleService userRolesService, BrandRepository brandsRepository, PasswordEncoder passwordEncoder, UserRoleRepository userRoleRepository, @Value("topsecret") String defaultPassword, UsersRepository usersRepository) {
        this.roleService = roleService;
        this.brandService = brandService;
        this.modelService = modelService;
        this.usersService = usersService;
        this.offerService = offerService;
        this.userRolesService = userRolesService;
        this.brandsRepository = brandsRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = userRoleRepository;
        this.defaultPassword = defaultPassword;
        this.usersRepository = usersRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();
    }

    private void seedData() {
        initRoles();
        initUsers();
        //        var date = LocalDateTime.now();
        //        AddUserRoleDto userRole1;
        //        AddUserRoleDto userRole2;
        //        userRole1 = new AddUserRoleDto();
        //        userRole2 = new AddUserRoleDto();
        //        userRole1.setRole(TypesOfRoles.USER);
        //        userRole2.setRole(TypesOfRoles.ADMIN);
        //        userRolesService.addUserRole(userRole1);
        //        userRolesService.addUserRole(userRole2);
        //        UniqueBrandNameValidator validator =new UniqueBrandNameValidator();
        //        validator.setBrandsRepository(brandsRepository);
        //        var user1 = new AddUsersDto();
        //        user1.setRoleId(roleService.getAll().get(0).getId().toString());
        //        user1.setUserName("User");
        //        user1.setPassword("1321312");
        //        user1.setFirstName("John");
        //        user1.setLastName("Doe");
        //        user1.setImageURL("yandex.ru");
        //        user1.setCreated(date);
        //        user1.setModified(date);
        //        usersService.addUser(user1);
        //        var brand1 = new AddBrandDto();
        //        brand1.setName("Brand");
        //        brand1.setCreated(date);
        //        brand1.setModified(date);
        //        brandService.addBrand(brand1);
        //        var model1 = new AddModelDto();
        //        model1.setBrandId(brandService.findByName(brand1.name).get().getId().toString());
        //        model1.setName("Model");
        //        model1.setCategory(CategoryOfVehicles.Car);
        //        model1.setStartYear(1800);
        //        model1.setEndYear(1800);
        //        model1.setCreated(date);
        //        model1.setModified(date);
        //        modelService.addModel(model1);
        //        var offer1 = new AddOfferDto();
        //        offer1.setDescription("12345678910");
        //        offer1.setUserId(usersService.userDetails(user1.getUserName()).getId().toString());
        //        offer1.setModelId(modelService.modelDetails(model1.getName()).getId().toString());
        //        offer1.setImageURL("https://th.bing.com/th/id/R.5a1b28d96b00ab3aef745893f991d65b?rik=RhijviGBJog01g&pid=ImgRaw&r=0");
        //        offer1.setMileage(100000);
        //        offer1.setPrice(100000);
        //        offer1.setTransmission(TypesOFTransmission.AUTOMATIC);
        //        offer1.setEngine(TypesOfGas.ELECTRIC);
        //        offer1.setYear("1900");
        //        offer1.setCreated(date);
        //        offer1.setModified(date);
        //        offerService.addOffer(offer1);

        //        System.out.println("Start test: \n");
        //        ShowDetailedUserRolesInfoDto role1 = new ShowDetailedUserRolesInfoDto(UUID.randomUUID(), TypesOfRoles.USER);
        //        ShowDetailedUserRolesInfoDto role2 = new ShowDetailedUserRolesInfoDto(UUID.randomUUID(), TypesOfRoles.ADMIN);
        //        role1 = roleService.register(role1);
        //        role2 = roleService.register(role2);
        //
        //        var role3 = new ShowDetailedUserRolesInfoDto(UUID.randomUUID(), TypesOfRoles.ADMIN);
        //        roleService.addUserRolesWithValidation(role3);
        //
        //        System.out.println(role1);
        //        System.out.println(role2);
        //
        //        var date = LocalDateTime.now();
        //
        //        var brand1 = new AddBrandDto( "Lada", date, date);
        //        var brand2 = new AddBrandDto( "Moscwich", date, date);
        //
        //        var brandWithValidationTest = new AddBrandDto( "I'm test", date, date);
        //        brandService.addBrandWithValidation(brandWithValidationTest);
        //        System.out.println(brandWithValidationTest);
        //
        //
        //        brand1 = brandService.register(brand1);
        //        brand2 = brandService.register(brand2);
        //        System.out.println(brand1);
        //        System.out.println(brand2);
        //
        //
        ////        ShowDetailedModelsInfoDto model1 = new ShowDetailedModelsInfoDto(UUID.randomUUID(), "Niva", CategoryOfVehicles.Car, "http://qwqwqwqw",
        ////                1999, 2023, date, date, brand1);
        ////        ShowDetailedModelsInfoDto model2 = new ShowDetailedModelsInfoDto(UUID.randomUUID(), "23", CategoryOfVehicles.Car, "http://kjkjkjkjk",
        ////                2022, 2023, date, date, brand2);
        ////        model1 = modelService.register(model1);
        ////        model2 = modelService.register(model2);
        //
        ////        var model3 = new ShowDetailedModelsInfoDto(UUID.randomUUID(), "Test", CategoryOfVehicles.Car, "http://kjkjkjkjk",
        ////                2022, 2023, date, date, brand2);
        ////        modelService.addModelWithValidation(model3);
        ////
        ////
        ////        System.out.println(model1);
        ////        System.out.println(model2);
        //
        //        ShowDetailedUsersInfoDto user1 = new ShowDetailedUsersInfoDto(UUID.randomUUID(), role1, "Kisa17", "555555", "Zlata",
        //                "Kikimora", true, "http://jjejfbejbf", date, date);
        //        ShowDetailedUsersInfoDto user2 = new ShowDetailedUsersInfoDto(UUID.randomUUID(), role2, "Gora", "6666666", "Morgan",
        //                "Freeman", true, "http://bebfebufbe", date, date);
        //        user1 = usersService.register(user1);
        //        user2 = usersService.register(user2);
        //
        //
        //        var user3 = new ShowDetailedUsersInfoDto(UUID.randomUUID(), role1, "Kisa17", "555555", "Zlata",
        //                "Test", true, "http://jjejfbejbf", date, date);
        //        usersService.addUserWithValidation(user3);
        //
        //
        //        System.out.println(user1);
        //        System.out.println(user2);
        //
        //        var price1 = 100_000;
        //        var price2 = 3_000_000;
        //
        ////        ShowDetailedOffersInfoDto offer1 = new ShowDetailedOffersInfoDto(UUID.randomUUID(), "Top in 1999", TypesOfGas.ELECTRIC,
        ////                "http://ya.ru", 20, price1, TypesOFTransmission.AUTOMATIC, 2022, date, date, model1, user2);
        ////        ShowDetailedOffersInfoDto offer2 = new ShowDetailedOffersInfoDto(UUID.randomUUID(), "Too much", TypesOfGas.GASOLINE,
        ////                "http://d", 2, price2, TypesOFTransmission.AUTOMATIC, 2022, date, date, model2, user2);
        ////        offerService.register(offer1);
        ////        offerService.register(offer2);
        ////
        ////        var offer3 = new ShowDetailedOffersInfoDto(UUID.randomUUID(), "Test", TypesOfGas.ELECTRIC,
        ////                "http://ya.ru", 20, price1, TypesOFTransmission.AUTOMATIC, 2022, date, date, model1, user2);
        //
        ////        offerService.addOfferWithValidation(offer3);
        ////
        ////
        ////        System.out.println(offer1);
        ////        System.out.println(offer2);
        //        // roleService.delete(1L);
        //        //usersService.delete(1L);
        //        //offerService.delete(1L);
        //        // brandService.delete(brand1.getId());

    }
    private void initRoles() {
        if (roleRepository.count() == 0) {
            var adminRole = new UserRole(Role.ADMIN);
            var normalUserRole = new UserRole(Role.USER);

            roleRepository.save(adminRole);
            roleRepository.save(normalUserRole);
        }
    }
    private void initAdmin(){
        var adminRole = roleRepository.findByRole(Role.ADMIN).orElseThrow();

        var adminUser = new Users("admin", passwordEncoder.encode(defaultPassword), "admin@example.com");
        adminUser.setRole(adminRole);

        usersRepository.save(adminUser);
    }
    private void initNormalUser(){
        var userRole = roleRepository.findByRole(Role.USER).orElseThrow();

        var normalUser = new Users("user", passwordEncoder.encode(defaultPassword), "user@example.com");
        normalUser.setRole(userRole);

        usersRepository.save(normalUser);
    }
    private void initUsers() {
        if (usersRepository.count() == 0) {
            initAdmin();
            initNormalUser();
        }
    }
}
