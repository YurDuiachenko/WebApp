package com.example.springdatabasicdemo.dtos.car;

import com.example.springdatabasicdemo.constants.Category;

public class CarDetailsDto {
    private  String name;
    private Category category;
    private  String imageURL;
    private  int startYear;
    private  int endYear;
    private String brandName;

    public CarDetailsDto() {
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

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public String toString() {
        return "CarDetailsDto{" +
            "name='" + name + '\'' +
            ", category=" + category +
            ", imageURL='" + imageURL + '\'' +
            ", startYear=" + startYear +
            ", endYear=" + endYear +
            ", brandName='" + brandName + '\'' +
            '}';
    }
}
