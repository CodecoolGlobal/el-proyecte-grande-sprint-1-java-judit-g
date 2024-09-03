package com.codecool.ratemydrivinginstructorbackend.controller;

import com.codecool.ratemydrivinginstructorbackend.controller.dto.InstructorDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.dto.NewInstructorDTO;
import com.codecool.ratemydrivinginstructorbackend.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/instructor")
public class InstructorController {

    private InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/all")
    public Set<InstructorDTO> getAllInstructors() {
        return instructorService.getAllInstructors();
    }

    @GetMapping("/{schoolId}")
    public Set<InstructorDTO> getInstructorsBySchoolId(@PathVariable Long schoolId) {
        return instructorService.getInstructorsBySchoolId(schoolId);
    }

    @GetMapping("/{instructorId}")
    public InstructorDTO getInstructor(@PathVariable Long instructorId) {
        return instructorService.getInstructorById(instructorId);
    }

    @PostMapping("/create")
    public void createInstructor(@RequestBody NewInstructorDTO newInstructorDTO) {
        instructorService.postNewInstructor(newInstructorDTO);
    }

    @PutMapping("/{instructorId}")
    public void updateInstructor(@PathVariable Long instructorId, @RequestBody InstructorDTO instructor) {
        instructorService.updateInstructor(instructorId, instructor);
    }

    @DeleteMapping("/{instructorId}")
    public void deleteInstructor(@PathVariable Long instructorId) {
        instructorService.deleteInstructor(instructorId);
    }
}
