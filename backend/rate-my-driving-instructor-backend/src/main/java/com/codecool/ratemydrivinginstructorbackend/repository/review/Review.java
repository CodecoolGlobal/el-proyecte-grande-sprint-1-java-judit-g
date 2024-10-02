package com.codecool.ratemydrivinginstructorbackend.repository.review;

import com.codecool.ratemydrivinginstructorbackend.repository.instructor.Instructor;
import com.codecool.ratemydrivinginstructorbackend.repository.appuser.AppUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue
    private long privateId;
    private UUID publicId = UUID.randomUUID();
    private String description;
    private int rating;
    private LocalDateTime publishingTime;


    @ManyToOne
    @JoinColumn(name = "appuser_private_id")
    private AppUser appUser;

    @ManyToOne
    @JoinColumn(name = "instructor_private_id")
    private Instructor instructor;

    public Review(String description, int rating, AppUser appUser, Instructor instructor) {
        this.description = description;
        this.rating = rating;
        this.appUser = appUser;
        this.instructor = instructor;
        this.publishingTime = LocalDateTime.now();
    }
}
