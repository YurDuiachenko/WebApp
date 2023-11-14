package com.example.springdatabasicdemo.models;

import com.example.springdatabasicdemo.constants.Category;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "models")
public class Model extends BaseEntity {

    private String name;
    private Category category;
    private String imageURL;
    private int startYear;
    private int endYear;
    private Brand brand;
    private Set<Offer> offers = new HashSet<>();

    public Model() {
    }

    public Model(String name, Category category, String imageURL, int startYear, int endYear, Brand brand, Set<Offer> offers) {
        this.name = name;
        this.category = category;
        this.imageURL = imageURL;
        this.startYear = startYear;
        this.endYear = endYear;
        this.brand = brand;
        this.offers = offers;
    }

    public Model(String name, Category category, String imageURL, int startYear, int endYear, Brand brand) {
        this.name = name;
        this.category = category;
        this.imageURL = imageURL;
        this.startYear = startYear;
        this.endYear = endYear;
        this.brand = brand;
    }

    @Column(name = "name", length = 255)
    public String getName() {
        return name;
    }

    @Column(name = "category")
    @Enumerated(value = EnumType.ORDINAL)
    public Category getCategory() {
        return category;
    }

    @Column(name = "image_url")
    public String getImageURL() {
        return imageURL;
    }
    @Column(name = "start_year")
    public int getStartYear() {
        return startYear;
    }

    @Column(name = "end_year")
    public int getEndYear() {
        return endYear;
    }

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.REFRESH)
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    public Brand getBrand() {
        return brand;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "model", cascade = CascadeType.REMOVE)
    public Set<Offer> getOffers() {
        return offers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }
}
