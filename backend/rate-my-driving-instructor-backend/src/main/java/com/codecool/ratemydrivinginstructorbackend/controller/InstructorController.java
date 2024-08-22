package com.codecool.ratemydrivinginstructorbackend.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InstructorController {
    private InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/instructor")
    public List<InstructorDTO> getAllinstructors() {
        return instructorService.getAllInstructors();
    }

    @GetMapping("/instructor/{instructorId}")
    public InstructorDTO getInstructor(@PathVariable int instructorId) {
        return instructorService.getInstructor(instructorId);
    }

    @PostMapping("/instructor")
    public void createInstructor(@RequestBody InstructorDTO instructor) {
        instructorService.createInstructor(instructor);
    }

    @PutMapping("/instructor/{instructorId}")
    public void updateInstructor(@PathVariable int instructorId, @RequestBody InstructorDTO instructor) {
        instructorService.updateInstructor(instructorId, instructor);
    }
}
