package com.codecool.ratemydrivinginstructorbackend.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.UUID;

public class MyUser extends User {
    protected String password;
    protected String username;
    protected UUID id;

    public MyUser(String password, String username, Collection<? extends GrantedAuthority> roles, UUID id) {
        super(username, password, roles);
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
