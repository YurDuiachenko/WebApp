package com.example.springdatabasicdemo.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private boolean isActive;
    private String imageUrl;
    private UserRole role;
    private Set<Offer> offers = new HashSet<>();

    public User() {}

    public User(String username, String password, String firstName, String lastName, boolean isActive, String imageUrl, UserRole role, Set<Offer> offers) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isActive = isActive;
        this.imageUrl = imageUrl;
        this.role = role;
        this.offers = offers;
    }

    public User(String username, String password, String firstName, String lastName, boolean isActive, String imageUrl, UserRole role) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isActive = isActive;
        this.imageUrl = imageUrl;
        this.role = role;
    }

    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    @Column(name = "is_active")
    public boolean isActive() {
        return isActive;
    }

    @Column(name = "image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    public UserRole getRole() {return role;}

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "seller", cascade = CascadeType.REMOVE)
    public Set<Offer> getOffers() {
        return offers;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }

}
