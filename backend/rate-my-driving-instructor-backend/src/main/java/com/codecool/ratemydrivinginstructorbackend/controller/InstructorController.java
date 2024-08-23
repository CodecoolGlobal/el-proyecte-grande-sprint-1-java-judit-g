package com.codecool.ratemydrivinginstructorbackend.controller;

import com.codecool.ratemydrivinginstructorbackend.controller.dto.InstructorDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.dto.NewInstructorDTO;
import com.codecool.ratemydrivinginstructorbackend.service.InstructorService;
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
        return instructorService.getInstructorById(instructorId);
    }

    @PostMapping("/instructor")
    public boolean createInstructor(@RequestBody NewInstructorDTO instructor) {
        return instructorService.createInstructor(instructor);
    }

    @PutMapping("/instructor/{instructorId}")
    public boolean updateInstructor(@PathVariable int instructorId, @RequestBody InstructorDTO instructor) {
        return instructorService.updateInstructor(instructorId, instructor);
    }

    @DeleteMapping("/instructor/{instructorId}")
    public boolean deleteInstructor(@PathVariable int instructorId) {
        return instructorService.deleteInstructor(instructorId);
    }
}
