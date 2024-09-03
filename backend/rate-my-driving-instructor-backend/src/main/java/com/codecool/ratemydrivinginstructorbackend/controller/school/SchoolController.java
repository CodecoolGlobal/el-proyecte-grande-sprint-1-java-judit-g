package com.codecool.ratemydrivinginstructorbackend.controller.school;

import com.codecool.ratemydrivinginstructorbackend.controller.school.schoolDTO.NewSchoolDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.school.schoolDTO.SchoolDTO;
import com.codecool.ratemydrivinginstructorbackend.service.school.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController("/api/school")
public class SchoolController {
    private SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping
    public List<SchoolDTO> getAllSchools() {
        return schoolService.getAllSchools();
    }

    @GetMapping("/{schoolId}")
    public SchoolDTO getSchool(@PathVariable long schoolId) {
        return schoolService.getSchoolById(schoolId);
    }

    @PostMapping
    public void createSchool(@RequestBody NewSchoolDTO school) {
        schoolService.createSchool(school);
    }

    @PutMapping("/{publicId}")
    public void updateSchool(@PathVariable UUID publicId, @RequestBody SchoolDTO school) {
        schoolService.updateSchool(publicId, school);
    }

    @DeleteMapping("/{publicId}")
    public void deleteInstructor(@PathVariable UUID publicId) {
        schoolService.deleteSchool(publicId);
    }
}