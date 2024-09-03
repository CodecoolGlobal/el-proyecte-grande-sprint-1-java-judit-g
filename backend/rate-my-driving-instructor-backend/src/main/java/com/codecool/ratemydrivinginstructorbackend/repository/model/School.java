package com.codecool.ratemydrivinginstructorbackend.repository.model;

import com.codecool.ratemydrivinginstructorbackend.repository.model.instructor.InstructorEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.HashSet;
import java.util.Set;

@Entity
public class School {

    private static final int schoolCount = 0;

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    //create a class from the address details
    private String city;
    private String streetName;
    private String streetNumber;
    private int postCode;
    private Set<InstructorEntity> instructors;
    private int phoneNumber;

    public School(String name, String city, String streetName, String streetNumber, int postCode, int phoneNumber) {
        this.name = name;
        this.city = city;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postCode = postCode;
        this.instructors = new HashSet<>();
        this.phoneNumber = phoneNumber;
    }

    public School() {

    }

    public boolean isId(int id) {
        return this.id == id;
    }

    public Long getId() {
        return id;
    }
}
