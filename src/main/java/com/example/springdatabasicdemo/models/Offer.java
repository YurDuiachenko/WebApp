package com.example.springdatabasicdemo.models;

import com.example.springdatabasicdemo.constants.Engine;
import com.example.springdatabasicdemo.constants.Transmission;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity {

    private String description;
    private Engine engine;
    private String imageUrl;
    private int mileage;
    private int price;
    private Transmission transmission;
    private int year;
    private Model model;
    private User seller;

    public Offer() {
    }

    public Offer(
            String description,
            Engine engine,
            String imageUrl,
            int mileage,
            int price,
            Transmission transmission,
            int year,
            Date created,
            Date modified,
            Model model,
            User seller
    ) {
        super.created = created;
        super.modified = modified;
        this.description = description;
        this.engine = engine;
        this.imageUrl = imageUrl;
        this.mileage = mileage;
        this.price = price;
        this.transmission = transmission;
        this.year = year;
        this.model = model;
        this.seller = seller;
    }

    public Offer(String description, Engine engine, String imageUrl, int mileage, int price, Transmission transmission, int year, Model model, User seller) {
        this.description = description;
        this.engine = engine;
        this.imageUrl = imageUrl;
        this.mileage = mileage;
        this.price = price;
        this.transmission = transmission;
        this.year = year;
        this.model = model;
        this.seller = seller;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    @Column(name = "engine")
    @Enumerated(value = EnumType.ORDINAL)
    public Engine getEngine() {
        return engine;
    }

    @Column(name = "image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    @Column(name = "mileage")
    public int getMileage() {
        return mileage;
    }

    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    @Column(name = "transmission")
    @Enumerated(value = EnumType.ORDINAL)
    public Transmission getTransmission() {
        return transmission;
    }

    @Column(name = "year")
    public int getYear() {
        return year;
    }

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "model_id", referencedColumnName = "id")
    public Model getModel() {
        return model;
    }

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "seller_id", referencedColumnName = "id")
    public User getSeller() {
        return seller;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "description='" + description + '\'' +
                ", engine=" + engine +
                ", imageUrl='" + imageUrl + '\'' +
                ", mileage=" + mileage +
                ", price=" + price +
                ", transmission=" + transmission +
                ", year=" + year +
                ", model=" + model +
                ", seller=" + seller +
                ", id=" + id +
                '}';
    }
}
