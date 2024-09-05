package com.codecool.ratemydrivinginstructorbackend.service.school;

import com.codecool.ratemydrivinginstructorbackend.controller.school.schoolDTO.AddressDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.school.schoolDTO.NewSchoolDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.school.schoolDTO.SchoolDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.school.schoolDTO.SchoolNameDTO;
import com.codecool.ratemydrivinginstructorbackend.repository.school.School;
import com.codecool.ratemydrivinginstructorbackend.repository.school.schooladdress.SchoolAddress;
import com.codecool.ratemydrivinginstructorbackend.service.instructor.InstructorMapper;


public class SchoolMapper {

    private InstructorMapper instructorMapper;

    public void setInstructorMapper(InstructorMapper instructorMapper) {
        this.instructorMapper = instructorMapper;
    }

    public School mapNewSchoolDTOToSchool(NewSchoolDTO newSchoolDTO) {
        return new School(
                newSchoolDTO.name(),
                newSchoolDTO.phoneNumber());
    }

    public SchoolDTO mapSchoolToSchoolDTO(School school) {
        return new SchoolDTO(
                school.getPublicId(),
                mapAddressToAddressDTO(school.getAddress()),
                school.getName(),
                school.getPhoneNumber(),
                instructorMapper.mapInstructorsToNameDTOs(school.getInstructors())
        );
    }

    private AddressDTO mapAddressToAddressDTO(SchoolAddress schoolAddress) {
        return new AddressDTO(
                schoolAddress.getPublicId(),
                schoolAddress.getCity(),
                schoolAddress.getStreetName(),
                schoolAddress.getStreetNumber(),
                schoolAddress.getPostCode()
        );
    }

    public SchoolAddress mapAddressDTOToAddress(AddressDTO addressDTO) {
        SchoolAddress schoolAddress = new SchoolAddress();
        schoolAddress.setCity(addressDTO.city());
        schoolAddress.setPostCode(addressDTO.postCode());
        schoolAddress.setStreetName(addressDTO.streetName());
        schoolAddress.setStreetNumber(addressDTO.streetNumber());
        return schoolAddress;
    }

    public SchoolNameDTO mapSchoolToSchoolNameDTO(School school) {
        return new SchoolNameDTO(school.getPublicId(), school.getName());
    }
}
