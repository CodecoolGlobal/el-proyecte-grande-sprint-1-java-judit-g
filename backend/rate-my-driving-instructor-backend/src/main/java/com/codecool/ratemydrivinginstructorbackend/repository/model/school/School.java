package com.codecool.ratemydrivinginstructorbackend.repository.model.school;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class School {
    @Id
    private long id;

    @OneToOne
    private Address address;

    @OneToMany
    private Set<Instructor> instructors;


    private UUID publicId;
    private String name;
    private String phoneNumber;

    public School(Address address, Set<Instructor> instructors, String name, String phoneNumber) {
        this.address = address;
        this.instructors = instructors;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.publicId = UUID.randomUUID();
    }

    public School() {
    }

    public School(String name, String phoneNumber) {
        this.name = name;
        this.instructors = new HashSet<>();
        this.phoneNumber = phoneNumber;
    }

    public boolean addInstructor(Instructor instructor) {
        return instructors.add(instructor);
    }

    public boolean isId(int id) {
        return this.id == id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(Set<Instructor> instructors) {
        this.instructors = instructors;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
