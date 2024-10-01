package com.codecool.ratemydrivinginstructorbackend.repository.appuser;

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
public class AppUser {

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

    public AppUser(String username, String password, List<Role> roles) {
        this.username = username;
        this.reviews = new ArrayList<>();
        this.password = password;
        this.roles = roles;
    }

    public AppUser(String username) {
        this.username = username;
    }

    public void addRole(Role role) {
        roles.add(role);
    }

}
