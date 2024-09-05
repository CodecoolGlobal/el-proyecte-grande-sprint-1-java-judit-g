package com.codecool.ratemydrivinginstructorbackend.service.school;

import com.codecool.ratemydrivinginstructorbackend.controller.school.schoolDTO.NewSchoolDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.school.schoolDTO.SchoolDTO;
import com.codecool.ratemydrivinginstructorbackend.repository.school.SchoolRepository;
import com.codecool.ratemydrivinginstructorbackend.repository.school.School;
import com.codecool.ratemydrivinginstructorbackend.repository.school.schooladdress.SchoolAddressRepository;
import com.codecool.ratemydrivinginstructorbackend.service.instructor.InstructorMapper;
import com.codecool.ratemydrivinginstructorbackend.service.school.exception.SchoolNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SchoolService {
    private final SchoolMapper schoolMapper;
    private final SchoolRepository schoolRepository;
    private final SchoolAddressRepository schoolAddressRepository;

    @Autowired
    public SchoolService(SchoolMapper schoolMapper, SchoolRepository schoolRepository, SchoolAddressRepository schoolAddressRepository) {
        this.schoolMapper = schoolMapper;
        this.schoolRepository = schoolRepository;
        this.schoolAddressRepository = schoolAddressRepository;
    }

    public List<SchoolDTO> getAllSchools() {
        List<School> schools = schoolRepository.findAll();
        return schools.stream()
                .map(schoolMapper::mapSchoolToSchoolDTO)
                .toList();
    }

    public SchoolDTO getSchoolById(UUID schoolId) {
        Optional<School> schoolOptional = schoolRepository.findByPublicId(schoolId);
        if (schoolOptional.isEmpty()) {
            throw new SchoolNotFoundException("There is no school with this id");
        }
        return schoolMapper.mapSchoolToSchoolDTO(schoolOptional.get());
    }

    public void createSchool(NewSchoolDTO school) {
        schoolAddressRepository.save(schoolMapper.mapAddressDTOToAddress(school.addressDTO()));
        schoolRepository.save(schoolMapper.mapNewSchoolDTOToSchool(school));
    }

    @Transactional
    public void updateSchool(UUID publicId, SchoolDTO schoolDTO) {
        Optional<School> schoolOptional = schoolRepository.findByPublicId(publicId);
        if (schoolOptional.isEmpty()) {
            throw new SchoolNotFoundException("There is no school with this id");
        }
        updateSchoolFromDTO(schoolDTO, schoolOptional.get());
    }

    @Transactional
    public void deleteSchool(UUID publicId) {
        Optional<School> schoolOptional = schoolRepository.findByPublicId(publicId);
        if (schoolOptional.isEmpty()) {
            throw new SchoolNotFoundException("There is no school with this id");
        }
        schoolRepository.deleteByPublicId(publicId);
    }

    private void updateSchoolFromDTO(SchoolDTO schoolDTO, School school) {
        school.setName(schoolDTO.name());
        school.setPhoneNumber(schoolDTO.phoneNumber());
    }
}
