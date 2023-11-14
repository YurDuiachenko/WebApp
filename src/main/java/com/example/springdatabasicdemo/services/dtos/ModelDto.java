package com.example.springdatabasicdemo.services.dtos;

import com.example.springdatabasicdemo.constants.Category;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public  class ModelDto {
    private UUID id;
    private  String name;
    private  Category category;
    private  String imageURL;
    private  int startYear;
    private  int endYear;
    private  Date created;
    private  Date modified;
    private  BrandDto brand;

    public ModelDto(
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

    public ModelDto(String name, Category category, String imageURL, int startYear, int endYear, Date created, Date modified, BrandDto brand) {
        this.name = name;
        this.category = category;
        this.imageURL = imageURL;
        this.startYear = startYear;
        this.endYear = endYear;
        this.created = created;
        this.modified = modified;
        this.brand = brand;
    }

    public ModelDto() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @NotNull
    @NotEmpty
    @Length(min = 2, message = "Name must be minimum two characters!")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    @NotEmpty
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

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (ModelDto) obj;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.category, that.category) &&
                Objects.equals(this.imageURL, that.imageURL) &&
                this.startYear == that.startYear &&
                this.endYear == that.endYear &&
                Objects.equals(this.created, that.created) &&
                Objects.equals(this.modified, that.modified) &&
                Objects.equals(this.brand, that.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, imageURL, startYear, endYear, created, modified, brand);
    }

    @Override
    public String toString() {
        return "ModelDto[" +
                "id=" + id + ", " +
                "name=" + name + ", " +
                "category=" + category + ", " +
                "imageURL=" + imageURL + ", " +
                "startYear=" + startYear + ", " +
                "endYear=" + endYear + ", " +
                "created=" + created + ", " +
                "modified=" + modified + ", " +
                "brand=" + brand + ']';
    }

}
