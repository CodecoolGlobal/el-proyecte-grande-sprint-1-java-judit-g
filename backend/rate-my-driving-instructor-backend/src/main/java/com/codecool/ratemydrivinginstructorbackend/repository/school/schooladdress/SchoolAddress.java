package com.codecool.ratemydrivinginstructorbackend.repository.school.schooladdress;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class SchoolAddress {

    @Id
    @GeneratedValue
    private long privateId;
    private UUID publicId = UUID.randomUUID();
    private String city;
    private String streetName;
    private String streetNumber;
    private int postCode;


    public long getPrivateId() {
        return privateId;
    }

    public void setPrivateId(long id) {
        this.privateId = id;
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

    public UUID getPublicId() {
        return publicId;
    }

    public void setPublicId(UUID publicId) {
        this.publicId = publicId;
    }
}
