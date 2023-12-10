package com.example.springdatabasicdemo.dtos.car;

import com.example.springdatabasicdemo.constants.Category;
import com.example.springdatabasicdemo.util.validation.car.UniqueModelName;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AddCarDto {
    private String brandName;
//    @UniqueModelName
    private  String name;
    private Category category;
    private  String imageURL;
    private  int startYear;
    private  int endYear;

//    @NotEmpty(message = "Brand name must not be null or empty!")
//    @Size(min = 2, max = 10, message = "Brand name must be between 2 and 10 characters!")
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }


//    @NotEmpty(message = "Model name must not be null or empty!")
//    @Size(min = 2, max = 10, message = "Model name must be between 2 and 10 characters!")
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
}
