package com.example.springdatabasicdemo.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "brands")
public class Brand extends BaseEntity {

    private String name;
    private Set<Model> models = new HashSet<>();

    public Brand() {
    }

    void addModel(Model model){models.add(model);}

    @Column(name = "name", length = 255)
    public String getName() {return name;}
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "brand", cascade = CascadeType.REMOVE)
    public Set<Model> getModels() {
        return models;
    }

    public void setName(String name) {this.name = name;}

    public void setModels(Set<Model> models) {
        this.models = models;
    }

}
