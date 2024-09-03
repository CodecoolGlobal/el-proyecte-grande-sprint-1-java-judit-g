package com.codecool.ratemydrivinginstructorbackend.service.school;

import com.codecool.ratemydrivinginstructorbackend.controller.instructor.instructorDTO.InstructorNameDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.school.schoolDTO.AddressDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.school.schoolDTO.NewSchoolDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.school.schoolDTO.SchoolDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.school.schoolDTO.SchoolNameDTO;
import com.codecool.ratemydrivinginstructorbackend.repository.instructor.Instructor;
import com.codecool.ratemydrivinginstructorbackend.repository.school.schooladdress.SchoolAddress;
import com.codecool.ratemydrivinginstructorbackend.repository.school.School;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class SchoolMapper {



    public School mapNewSchoolDTOToSchool(NewSchoolDTO newSchoolDTO) {
        return new School(
                newSchoolDTO.name(),
                newSchoolDTO.phoneNumber());
    }

    public SchoolDTO mapSchoolToSchoolDTO(School school) {
        return new SchoolDTO(
                mapAddressToAddressDTO(school.getAddress()),
                school.getName(),
                school.getPhoneNumber(),
                mapInstructorsToNameDTOs(school.getInstructors())
        );
    }

    private AddressDTO mapAddressToAddressDTO(SchoolAddress schoolAddress) {
        return new AddressDTO(
                schoolAddress.getCity(),
                schoolAddress.getStreetName(),
                schoolAddress.getStreetNumber(),
                schoolAddress.getPostCode()
        );
    }

    public SchoolNameDTO mapSchoolToSchoolNameDTO(School school) {
        return new SchoolNameDTO(school.getPublicId(), school.getName());
    }

    private Set<InstructorNameDTO> mapInstructorsToNameDTOs(Set<Instructor> instructors) {
        return instructors.stream()
                .map(instructor -> new InstructorNameDTO(
                        instructor.getFirstName(),
                        instructor.getLastName(),
                        instructor.getPublicId()))
                .collect(Collectors.toSet());
    }



}
