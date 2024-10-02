package com.codecool.ratemydrivinginstructorbackend.controller.school;

import com.codecool.ratemydrivinginstructorbackend.controller.school.schoolDTO.NewSchoolDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.school.schoolDTO.SchoolDTO;
import com.codecool.ratemydrivinginstructorbackend.service.school.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/school")
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
    public SchoolDTO getSchool(@PathVariable UUID schoolId) {
        return schoolService.getSchoolById(schoolId);
    }

    @GetMapping("/count")
    public int getNumberOfSchools() {
        return schoolService.countNumberOfSchools();
    }

}
