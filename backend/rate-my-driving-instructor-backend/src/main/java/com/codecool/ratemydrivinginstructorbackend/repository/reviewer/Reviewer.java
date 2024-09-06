package com.codecool.ratemydrivinginstructorbackend.repository.reviewer;

import com.codecool.ratemydrivinginstructorbackend.repository.review.Review;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Reviewer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long privateId;

    private UUID publicId = UUID.randomUUID();

    private String name;

    @JoinColumn(name = "reviewer_private_id")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @OneToMany(cascade = CascadeType.PERSIST)
    List<Review> reviews = new ArrayList<>();

    public Reviewer() {

    }

    public Reviewer(String name) {
        this.name = name;
        this.reviews = new ArrayList<>();
    }

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

    public void setPrivateId(long privateId) {
        this.privateId = privateId;
    }

    public void setPublicId(UUID publicId) {
        this.publicId = publicId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
