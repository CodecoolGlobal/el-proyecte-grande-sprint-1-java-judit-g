package com.codecool.ratemydrivinginstructorbackend.security.service;

import com.codecool.ratemydrivinginstructorbackend.repository.appuser.AppUser;
import com.codecool.ratemydrivinginstructorbackend.repository.appuser.ReviewerRepository;
import com.codecool.ratemydrivinginstructorbackend.repository.appuser.Role;
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
        AppUser appUserEntity = reviewerRepository.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));

        List<SimpleGrantedAuthority> roles = new ArrayList<>();
        for (Role role : appUserEntity.getRoles()) {
            roles.add(new SimpleGrantedAuthority(role.name()));
        }

        return new User(appUserEntity.getUsername(), appUserEntity.getPassword(), roles);
    }
}
