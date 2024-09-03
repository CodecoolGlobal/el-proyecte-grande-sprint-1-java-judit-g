package com.codecool.ratemydrivinginstructorbackend.service;

import com.codecool.ratemydrivinginstructorbackend.controller.dto.school.NewSchoolDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.dto.school.SchoolDTO;
import com.codecool.ratemydrivinginstructorbackend.repository.SchoolRepository;
import com.codecool.ratemydrivinginstructorbackend.repository.model.school.School;
import com.codecool.ratemydrivinginstructorbackend.service.exception.SchoolNotFoundException;
import com.codecool.ratemydrivinginstructorbackend.service.mapper.SchoolMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SchoolService {
    private final SchoolMapper schoolMapper;
    private SchoolRepository schoolRepository;

    @Autowired
    public SchoolService(SchoolRepository schoolRepository, SchoolMapper schoolMapper) {
        this.schoolRepository = schoolRepository;
        this.schoolMapper = schoolMapper;
    }

    public List<SchoolDTO> getAllSchools() {
        List<School> schools = schoolRepository.findAll();
        return schools.stream()
                .map(school -> schoolMapper.mapSchoolToSchoolDTO(school))
                .toList();
    }

    public SchoolDTO getSchoolById(long schoolId) {
        Optional<School> schoolOptional = schoolRepository.findById(schoolId);
        if (schoolOptional.isEmpty()) {
            throw new SchoolNotFoundException("There is no school with this id");
        }
        return schoolMapper.mapSchoolToSchoolDTO(schoolOptional.get());
    }

    public void createSchool(NewSchoolDTO school) {
        schoolRepository.save(schoolMapper.mapNewSchoolDTOToSchool(school));
    }

    public void updateSchool(UUID publicId, SchoolDTO schoolDTO) {
        Optional<School> schoolOptional = schoolRepository.findByPublicId(publicId);
        if (schoolOptional.isEmpty()) {
            throw new SchoolNotFoundException("There is no school with this id");
        }
        schoolRepository.save(schoolMapper.updateSchoolFromDTO(schoolDTO, schoolOptional.get()));
    }

    public void deleteSchool(UUID publicId) {
        Optional<School> schoolOptional = schoolRepository.findByPublicId(publicId);
        if (schoolOptional.isEmpty()) {
            throw new SchoolNotFoundException("There is no school with this id");
        }
        schoolRepository.deleteByPublicId(publicId);
    }
}
