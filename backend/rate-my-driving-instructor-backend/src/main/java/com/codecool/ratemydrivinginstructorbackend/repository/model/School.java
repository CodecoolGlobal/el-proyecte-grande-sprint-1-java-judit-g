package com.codecool.ratemydrivinginstructorbackend.repository.model;

import java.util.HashSet;
import java.util.Set;

public class School {

    private static final int schoolCount = 0;

    private int id;
    private String name;
    //create a class from the address details
    private String city;
    private String streetName;
    private String streetNumber;
    private int postCode;
    private Set<Instructor> instructors;
    private int phoneNumber;

    public School(String name, String city, String streetName, String streetNumber, int postCode, int phoneNumber) {
        this.id = schoolCount;
        this.name = name;
        this.city = city;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postCode = postCode;
        this.instructors = new HashSet<>();
        this.phoneNumber = phoneNumber;
    }

    public boolean addInstructor(Instructor instructor) {
        return instructors.add(instructor);
    }

    public boolean isId(int id) {
        return this.id == id;
    }

    public int getId() {
        return id;
    }
}
