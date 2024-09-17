package com.codecool.ratemydrivinginstructorbackend.security.service;

import com.codecool.ratemydrivinginstructorbackend.repository.reviewer.Reviewer;
import com.codecool.ratemydrivinginstructorbackend.repository.reviewer.ReviewerRepository;
import com.codecool.ratemydrivinginstructorbackend.repository.reviewer.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final ReviewerRepository reviewerRepository;


    @Autowired
    public UserDetailsServiceImpl(ReviewerRepository reviewerRepository) {
        this.reviewerRepository = reviewerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Reviewer reviewerEntity = reviewerRepository.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));

        List<SimpleGrantedAuthority> roles = new ArrayList<>();
        for (Role role : reviewerEntity.getRoles()) {
            roles.add(new SimpleGrantedAuthority(role.name()));
        }

        return new User(reviewerEntity.getUsername(), reviewerEntity.getPassword(), roles);
    }
}
