package com.codecool.ratemydrivinginstructorbackend.controller;

import com.codecool.ratemydrivinginstructorbackend.dto.InstructorDTO;
import com.codecool.ratemydrivinginstructorbackend.dto.NewInstructorDTO;
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
    public void createInstructor(@RequestBody NewInstructorDTO instructor) {
        instructorService.createInstructor(instructor);
    }

    @PutMapping("/instructor/{instructorId}")
    public void updateInstructor(@PathVariable int instructorId, @RequestBody InstructorDTO instructor) {
        instructorService.updateInstructor(instructorId, instructor);
    }

    @DeleteMapping("/instructor/{instructorId}")
    public void deleteInstructor(@PathVariable int instructorId) {
        instructorService.deleteInstructor(instructorId);
    }
}
