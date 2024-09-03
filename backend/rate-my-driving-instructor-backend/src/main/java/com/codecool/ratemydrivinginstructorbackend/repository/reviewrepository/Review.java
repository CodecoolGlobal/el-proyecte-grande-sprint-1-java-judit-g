package com.codecool.ratemydrivinginstructorbackend.repository.reviewrepository;

import com.codecool.ratemydrivinginstructorbackend.repository.instructorrepository.Instructor;
import com.codecool.ratemydrivinginstructorbackend.repository.reviewerrepository.Reviewer;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Review {

    @Id
    @GeneratedValue
    private long privateId;
    private UUID publicId;
    private String description;
    private int rating;

    public Review() {
    }

    public Review(String description, int rating, Reviewer reviewer, Instructor instructor) {
        this.description = description;
        this.rating = rating;
        this.reviewer = reviewer;
        this.instructor = instructor;
    }

    @ManyToOne
    @JoinColumn(name = "reviewer_id")
    private Reviewer reviewer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;


    public long getPrivateId() {
        return privateId;
    }

    public UUID getPublicId() {
        return publicId;
    }

    public String getDescription() {
        return description;
    }

    public int getRating() {
        return rating;
    }

    public Reviewer getReviewer() {
        return reviewer;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setPublicId(UUID publicId) {
        this.publicId = publicId;
    }

    public UUID getReviewerPublicId() {
        return reviewer.getPublicId();
    }

    public UUID getInstructorPublicId() {
        return instructor.getPublicId();
    }

    public void setPrivateId(long privateId) {
        this.privateId = privateId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setReviewer(Reviewer reviewer) {
        this.reviewer = reviewer;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
