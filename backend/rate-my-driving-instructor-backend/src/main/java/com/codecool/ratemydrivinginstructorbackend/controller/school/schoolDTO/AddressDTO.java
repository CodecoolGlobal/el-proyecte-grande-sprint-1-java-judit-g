package com.codecool.ratemydrivinginstructorbackend.controller.school.schoolDTO;

import java.util.UUID;

public record AddressDTO(UUID publicId, String city, String streetName, String streetNumber, int postCode) {
}
