package com.codecool.ratemydrivinginstructorbackend.service.school;

import com.codecool.ratemydrivinginstructorbackend.controller.instructor.instructorDTO.InstructorNameDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.school.schoolDTO.AddressDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.school.schoolDTO.NewSchoolDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.school.schoolDTO.SchoolDTO;
import com.codecool.ratemydrivinginstructorbackend.repository.school.schooladdress.SchoolAddress;
import com.codecool.ratemydrivinginstructorbackend.repository.school.School;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class SchoolMapper {

    public School mapNewSchoolDTOToSchool(NewSchoolDTO newSchoolDTO) {
        return new School(
                newSchoolDTO.name(),
                newSchoolDTO.phoneNumber());
    }

    public SchoolDTO mapSchoolToSchoolDTO(School school, AddressDTO addressDTO, Set<InstructorNameDTO> instructorNameDTOs) {
        return new SchoolDTO(
                addressDTO,
                school.getName(),
                school.getPhoneNumber(),
                instructorNameDTOs
        );
    }

    public AddressDTO mapAddressToAddressDTO(SchoolAddress schoolAddress) {
        return new AddressDTO(
                schoolAddress.getCity(),
                schoolAddress.getStreetName(),
                schoolAddress.getStreetNumber(),
                schoolAddress.getPostCode()
        );
    }
}
