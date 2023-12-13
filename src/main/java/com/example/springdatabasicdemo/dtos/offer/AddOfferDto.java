package com.example.springdatabasicdemo.dtos.offer;

import com.example.springdatabasicdemo.constants.Engine;
import com.example.springdatabasicdemo.constants.Transmission;
import com.example.springdatabasicdemo.dtos.car.ModelDto;
import com.example.springdatabasicdemo.dtos.user.UserDto;
import com.example.springdatabasicdemo.models.Model;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class AddOfferDto {
    private UUID id;
    private  String description;
    private Engine engine;
    private  String imageUrl;
    private  int mileage;
    private  int price;
    private Transmission transmission;
    private  int year;
    private Date created;
    private  Date modified;
    private ModelDto model;
    private UserDto seller;
    private String modelName;
    private String sellerName;

    public AddOfferDto(
        UUID id,
        String description,
        Engine engine,
        String imageUrl,
        int mileage,
        int price,
        Transmission transmission,
        int year,
        Date created,
        Date modified,
        ModelDto model,
        UserDto seller
    ) {
        this.id = id;
        this.description = description;
        this.engine = engine;
        this.imageUrl = imageUrl;
        this.mileage = mileage;
        this.price = price;
        this.transmission = transmission;
        this.year = year;
        this.created = created;
        this.modified = modified;
        this.model = model;
        this.seller = seller;
    }

    public AddOfferDto(String description, Engine engine, String imageUrl, int mileage, int price, Transmission transmission, int year, Date created, Date modified, ModelDto model, UserDto seller) {
        this.description = description;
        this.engine = engine;
        this.imageUrl = imageUrl;
        this.mileage = mileage;
        this.price = price;
        this.transmission = transmission;
        this.year = year;
        this.created = created;
        this.modified = modified;
        this.model = model;
        this.seller = seller;
    }

    public AddOfferDto() {
    }
    public AddOfferDto(ModelDto model) {
        this.model = model;
        this.modelName = getModelName();
    }

    public UUID id() {
        return id;
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

    public ModelDto getModel() {
        return model;
    }

    public void setModel(ModelDto model) {
        this.model = model;
    }

    public UserDto getSeller() {
        return seller;
    }

    public void setSeller(UserDto seller) {
        this.seller = seller;
    }

    public String description() {
        return description;
    }

    public Engine engine() {
        return engine;
    }

    public String imageUrl() {
        return imageUrl;
    }

    public int mileage() {
        return mileage;
    }

    public int price() {
        return price;
    }

    public Transmission transmission() {
        return transmission;
    }

    public int year() {
        return year;
    }

    public Date created() {
        return created;
    }

    public Date modified() {
        return modified;
    }

    public ModelDto model() {
        return model;
    }

    public UserDto seller() {
        return seller;
    }

    public String getModelName() {
        return getModel().name();
    }

    public void setModelName() {
        this.modelName = getSeller().username();
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, engine, imageUrl, mileage, price, transmission, year, created, modified, model, seller);
    }
}
