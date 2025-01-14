package com.codecool.ratemydrivinginstructorbackend.controller.instructor;

import com.codecool.ratemydrivinginstructorbackend.controller.instructor.instructorDTO.InstructorDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.instructor.instructorDTO.NewInstructorDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.school.schoolDTO.SchoolDTO;
import com.codecool.ratemydrivinginstructorbackend.service.instructor.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/api/instructor")
public class InstructorController {

    private final InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/all")
    public Set<InstructorDTO> getAllInstructors() {
        return instructorService.getAllInstructors();
    }

    @GetMapping("/school/{schoolId}")
    public Set<InstructorDTO> getInstructorsBySchoolPublicId(@PathVariable UUID schoolId) {
        return instructorService.getInstructorsBySchoolId(schoolId);
    }

    @GetMapping("/{instructorId}")
    public InstructorDTO getInstructor(@PathVariable UUID instructorId) {
        return instructorService.getInstructorByPublicId(instructorId);
    }

    @PostMapping("/create")
    public InstructorDTO createInstructor(@RequestBody NewInstructorDTO newInstructorDTO) {
        return instructorService.postNewInstructor(newInstructorDTO);
    }

}

