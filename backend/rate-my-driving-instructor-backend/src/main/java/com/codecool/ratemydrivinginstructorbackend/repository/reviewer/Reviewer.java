package com.codecool.ratemydrivinginstructorbackend.repository.reviewer;

import com.codecool.ratemydrivinginstructorbackend.repository.review.Review;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.*;

@Entity
public class Reviewer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long privateId;

    private UUID publicId = UUID.randomUUID();

    private String username;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "user_role")
    private List<Role> roles = new ArrayList<>();

    @JoinColumn(name = "reviewer_private_id")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Review> reviews = new ArrayList<>();

    private String password;

    public Reviewer() {

    }

    public Reviewer(String username, String password, List<Role> roles) {
        this.username = username;
        this.reviews = new ArrayList<>();
        this.password = password;
        this.roles = roles;
    }

    public Reviewer(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void addRole(Role role) {
        roles.add(role);
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public long getPrivateId() {
        return privateId;
    }

    public UUID getPublicId() {
        return publicId;
    }

    public String getUsername() {
        return username;
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

    public void setUsername(String name) {
        this.username = name;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
