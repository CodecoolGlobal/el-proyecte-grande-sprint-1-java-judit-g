package com.codecool.ratemydrivinginstructorbackend.repository.instructor;

import com.codecool.ratemydrivinginstructorbackend.repository.school.School;
import com.codecool.ratemydrivinginstructorbackend.repository.review.Review;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long privateId;

    private UUID publicId = UUID.randomUUID();

    private String firstName;

    private String lastName;

    private double avgRating;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private School school;

    @ElementCollection(targetClass = LicenseType.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "instructor_license_types", joinColumns = @JoinColumn(name = "instructor_id"))
    @Column(name = "license_type")
    private Set<LicenseType> licenseType;

    @JoinColumn(name = "instructor_private_id")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Review> reviews = new ArrayList<>();

    public Instructor(String firstName, String lastName, School school, List<Review> reviews, Set<LicenseType> licenseType, double avgRating) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.school = school;
        this.reviews = new ArrayList<>(reviews);
        this.licenseType = new HashSet<>(licenseType);
        this.avgRating = avgRating;
    }

    public Instructor(String s, String s1, School school, Set<LicenseType> licenseType) {
        this.firstName = s;
        this.lastName = s1;
        this.school = school;
        this.reviews = new ArrayList<>();
        this.licenseType = licenseType;
    }

    public double getAvgRating() {
        return reviews.stream()
                .mapToDouble(Review::getRating)
                .average()
                .orElse(0);
    }

    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }

    public void addReview(Review review) {
        reviews.add(review);
    }
}
