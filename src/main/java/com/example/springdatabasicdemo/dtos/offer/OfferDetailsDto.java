package com.example.springdatabasicdemo.dtos.offer;

import com.example.springdatabasicdemo.constants.Engine;
import com.example.springdatabasicdemo.constants.Transmission;

import java.util.UUID;

public class OfferDetailsDto {
    public UUID id;
    public  String description;
    public Engine engine;
    public  String imageUrl;
    public  int mileage;
    public  int price;
    public Transmission transmission;
    public  int year;
    public String modelName;
    public String sellerFirstName;
    public String sellerLastName;

    public OfferDetailsDto(
        String description,
        Engine engine,
        String imageUrl,
        int mileage,
        int price,
        Transmission transmission,
        int year
    ) {
        this.description = description;
        this.engine = engine;
        this.imageUrl = imageUrl;
        this.mileage = mileage;
        this.price = price;
        this.transmission = transmission;
        this.year = year;
    }

    public OfferDetailsDto() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getSellerFirstName() {
        return sellerFirstName;
    }

    public void setSellerFirstName(String sellerFirstName) {
        this.sellerFirstName = sellerFirstName;
    }

    public String getSellerLastName() {
        return sellerLastName;
    }

    public void setSellerLastName(String sellerLastName) {
        this.sellerLastName = sellerLastName;
    }
}
