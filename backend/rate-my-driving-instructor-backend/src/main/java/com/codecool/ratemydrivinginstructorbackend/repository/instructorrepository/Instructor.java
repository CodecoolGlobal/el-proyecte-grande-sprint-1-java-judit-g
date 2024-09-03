package com.codecool.ratemydrivinginstructorbackend.repository.instructorrepository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Instructor {

    @Id
    @GeneratedValue
    private UUID publicId;
    private long privateId;
    private String firstName;
    private String lastName;


    public UUID getPublicId() {
        return publicId;
    }

    public long getPrivateId() {
        return privateId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
