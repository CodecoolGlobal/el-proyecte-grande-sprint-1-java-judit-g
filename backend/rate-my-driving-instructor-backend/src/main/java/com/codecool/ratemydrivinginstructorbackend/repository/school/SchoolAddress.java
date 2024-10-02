package com.codecool.ratemydrivinginstructorbackend.repository.school;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SchoolAddress {
    private String city;
    private String streetName;
    private String streetNumber;
    private int postCode;
}
