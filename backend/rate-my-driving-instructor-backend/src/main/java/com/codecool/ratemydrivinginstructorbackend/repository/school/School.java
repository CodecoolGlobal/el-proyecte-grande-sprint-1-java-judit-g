package com.codecool.ratemydrivinginstructorbackend.repository.school;


import com.codecool.ratemydrivinginstructorbackend.repository.instructor.Instructor;
import com.codecool.ratemydrivinginstructorbackend.repository.school.schooladdress.SchoolAddress;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long privateId;
    private UUID publicId = UUID.randomUUID();

    @OneToOne(cascade = CascadeType.ALL)
    private SchoolAddress schoolAddress;

    @JoinColumn(name = "school_private_id")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<Instructor> instructors = new HashSet<>();

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
}
