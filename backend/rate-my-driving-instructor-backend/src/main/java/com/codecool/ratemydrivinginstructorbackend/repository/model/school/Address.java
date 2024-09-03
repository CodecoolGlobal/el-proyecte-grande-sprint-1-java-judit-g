package com.codecool.ratemydrivinginstructorbackend.repository.model.school;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Address {
    @Id
    private long id;

    private UUID publicId;
    private String city;
    private String streetName;
    private String streetNumber;
    private int postCode;

    public Address(int id, String city, String streetName, String streetNumber, int postCode) {
        this.id = id;
        this.city = city;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postCode = postCode;
        this.publicId = UUID.randomUUID();
    }

    public Address() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }
}
