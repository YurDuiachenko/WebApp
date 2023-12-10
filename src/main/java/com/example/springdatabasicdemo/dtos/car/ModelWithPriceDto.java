package com.example.springdatabasicdemo.dtos.car;

import com.example.springdatabasicdemo.constants.Category;
import com.example.springdatabasicdemo.dtos.brand.BrandDto;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

/**
 * todo Document type ModelWithPriceDto
 */
public class ModelWithPriceDto {
    private UUID id;
    private  String name;
    private Category category;
    private  String imageURL;
    private double price;
    private  int startYear;
    private  int endYear;
    private Date created;
    private  Date modified;
    private BrandDto brand;
    private double discount = 0.88;
    private double newPrice =  Math.floor(price * discount) - 0.01;

    public ModelWithPriceDto(
        UUID id,
        String name,
        Category category,
        String imageURL,
        int startYear,
        int endYear,
        Date created,
        Date modified,
        BrandDto brand
    ) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.imageURL = imageURL;
        this.startYear = startYear;
        this.endYear = endYear;
        this.created = created;
        this.modified = modified;
        this.brand = brand;
    }

    public ModelWithPriceDto(String name, Category category, String imageURL, int startYear, int endYear, Date created, Date modified, BrandDto brand) {
        this.name = name;
        this.category = category;
        this.imageURL = imageURL;
        this.startYear = startYear;
        this.endYear = endYear;
        this.created = created;
        this.modified = modified;
        this.brand = brand;
    }

    public ModelWithPriceDto(String name, Category category, String imageURL, double price, int startYear, int endYear, Date created, Date modified) {
        this.name = name;
        this.category = category;
        this.imageURL = imageURL;
        this.price = price;
        this.startYear = startYear;
        this.endYear = endYear;
        this.created = created;
        this.modified = modified;
    }

    public ModelWithPriceDto(String name, Category category, String imageURL, double price, int startYear, int endYear) {
        this.name = name;
        this.category = category;
        this.imageURL = imageURL;
        this.price = price;
        this.startYear = startYear;
        this.endYear = endYear;
    }

    public ModelWithPriceDto(String name, Category category, String imageURL, double price, int startYear, int endYear, Date created, Date modified, BrandDto brand) {
        this.name = name;
        this.category = category;
        this.imageURL = imageURL;
        this.price = price;
        this.startYear = startYear;
        this.endYear = endYear;
        this.created = created;
        this.modified = modified;
        this.brand = brand;
    }

    public ModelWithPriceDto(UUID id, String name, Category category, String imageURL, double price, int startYear, int endYear, Date created, Date modified,
        BrandDto brand, double discount, double newPrice) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.imageURL = imageURL;
        this.price = price;
        this.startYear = startYear;
        this.endYear = endYear;
        this.created = created;
        this.modified = modified;
        this.brand = brand;
        this.discount = discount;
        this.newPrice = getNewPrice();
    }

    public ModelWithPriceDto(String name, Category category, String imageURL, double price, int startYear, int endYear, Date created, Date modified,
        BrandDto brand,
        double discount, double newPrice) {
        this.name = name;
        this.category = category;
        this.imageURL = imageURL;
        this.price = price;
        this.startYear = startYear;
        this.endYear = endYear;
        this.created = created;
        this.modified = modified;
        this.brand = brand;
        this.discount = discount;
        this.newPrice = getNewPrice();
    }

    public ModelWithPriceDto() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public BrandDto getBrand() {
        return brand;
    }

    public void setBrand(BrandDto brand) {
        this.brand = brand;
    }

    public UUID id() {
        return id;
    }

    public String name() {
        return name;
    }

    public Category category() {
        return category;
    }

    public String imageURL() {
        return imageURL;
    }

    public int startYear() {
        return startYear;
    }

    public int endYear() {
        return endYear;
    }

    public Date created() {
        return created;
    }

    public Date modified() {
        return modified;
    }

    public BrandDto brand() {
        return brand;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getNewPrice() {
        return Math.floor(price * discount) - 0.01;
    }

    public void setNewPrice(double newPrice) {
        this.newPrice = Math.floor(price * discount) - 0.01;
    }
}
