package com.codecool.ratemydrivinginstructorbackend.service.school;

import com.codecool.ratemydrivinginstructorbackend.controller.school.schoolDTO.NewSchoolDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.school.schoolDTO.SchoolDTO;
import com.codecool.ratemydrivinginstructorbackend.repository.school.SchoolRepository;
import com.codecool.ratemydrivinginstructorbackend.repository.school.School;
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
    private final InstructorMapper instructorMapper;

    @Autowired
    public SchoolService(SchoolMapper schoolMapper, SchoolRepository schoolRepository, InstructorMapper instructorMapper) {
        this.schoolMapper = schoolMapper;
        this.schoolRepository = schoolRepository;
        this.instructorMapper = instructorMapper;
    }

    public List<SchoolDTO> getAllSchools() {
        List<School> schools = schoolRepository.findAll();
        return schools.stream()
                .map(school -> schoolMapper.mapSchoolToSchoolDTO(school, instructorMapper))
                .toList();
    }

    public SchoolDTO getSchoolById(long schoolId) {
        Optional<School> schoolOptional = schoolRepository.findById(schoolId);
        if (schoolOptional.isEmpty()) {
            throw new SchoolNotFoundException("There is no school with this id");
        }
        return schoolMapper.mapSchoolToSchoolDTO(schoolOptional.get(), instructorMapper);
    }

    public void createSchool(NewSchoolDTO school) {

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
