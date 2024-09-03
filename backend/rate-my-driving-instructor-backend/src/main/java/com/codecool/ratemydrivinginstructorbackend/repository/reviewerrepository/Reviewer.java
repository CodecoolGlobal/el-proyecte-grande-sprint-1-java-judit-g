package com.codecool.ratemydrivinginstructorbackend.repository.reviewerrepository;

import com.codecool.ratemydrivinginstructorbackend.repository.reviewrepository.Review;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class Reviewer {

    @Id
    @GeneratedValue
    private long privateId;
    private UUID publicId;
    private String name;

    @OneToMany
    List<Review> reviews;

    public long getPrivateId() {
        return privateId;
    }

    public UUID getPublicId() {
        return publicId;
    }

    public String getName() {
        return name;
    }

    public List<Review> getReviews() {
        return reviews;
    }
}
