package com.codecool.ratemydrivinginstructorbackend.repository.school;


import com.codecool.ratemydrivinginstructorbackend.repository.instructor.Instructor;
import com.codecool.ratemydrivinginstructorbackend.repository.school.schooladdress.SchoolAddress;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class School {

    @Id
    @GeneratedValue
    private long privateId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "private_id")
    private SchoolAddress schoolAddress;

    @OneToMany
    private Set<Instructor> instructors;

    private UUID publicId = UUID.randomUUID();
    private String name;
    private String phoneNumber;

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
        return this.privateId == id;
    }

    public long getPrivateId() {
        return privateId;
    }

    public void setPrivateId(long id) {
        this.privateId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SchoolAddress getAddress() {
        return schoolAddress;
    }

    public void setAddress(SchoolAddress schoolAddress) {
        this.schoolAddress = schoolAddress;
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

    public UUID getPublicId() {
        return publicId;
    }

    public void setPublicId(UUID publicId) {
        this.publicId = publicId;
    }
}
