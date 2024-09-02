package com.codecool.ratemydrivinginstructorbackend.controller;

import com.codecool.ratemydrivinginstructorbackend.controller.dto.InstructorDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.dto.NewInstructorDTO;
import com.codecool.ratemydrivinginstructorbackend.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructor")
public class InstructorController {

    private InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping
    public List<InstructorDTO> getAllInstructors() {
        return instructorService.getAllInstructors();
    }

    @GetMapping("/{instructorId}")
    public InstructorDTO getInstructor(@PathVariable int instructorId) {
        return instructorService.getInstructorById(instructorId);
    }

    @PostMapping
    public boolean createInstructor(@RequestBody NewInstructorDTO instructor) {
        return instructorService.createInstructor(instructor);
    }

    @PutMapping("/{instructorId}")
    public boolean updateInstructor(@PathVariable int instructorId, @RequestBody InstructorDTO instructor) {
        return instructorService.updateInstructor(instructorId, instructor);
    }

    @DeleteMapping("/{instructorId}")
    public boolean deleteInstructor(@PathVariable int instructorId) {
        return instructorService.deleteInstructor(instructorId);
    }
}
