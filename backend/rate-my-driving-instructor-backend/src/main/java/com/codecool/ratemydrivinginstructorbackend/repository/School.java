package com.codecool.ratemydrivinginstructorbackend.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class School {

    @Id
    private int id;
    private String name;

}
