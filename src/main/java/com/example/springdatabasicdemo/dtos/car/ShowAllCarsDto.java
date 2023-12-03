package com.example.springdatabasicdemo.dtos.car;

import com.example.springdatabasicdemo.constants.Category;
import com.example.springdatabasicdemo.dtos.brand.BrandDto;

public class ShowAllCarsDto {
    private  String name;
    private  Category category;
    private  String imageURL;
    private BrandDto brand;

    public ShowAllCarsDto(String name, Category category, String imageURL, BrandDto brand) {
        this.name = name;
        this.category = category;
        this.imageURL = imageURL;
        this.brand = brand;
    }

    public ShowAllCarsDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public BrandDto getBrand() {
        return brand;
    }

    public void setBrand(BrandDto brand) {
        this.brand = brand;
    }
}
