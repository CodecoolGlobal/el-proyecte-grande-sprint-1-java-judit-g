package com.codecool.ratemydrivinginstructorbackend.service;

import com.codecool.ratemydrivinginstructorbackend.controller.dto.InstructorDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.dto.NewInstructorDTO;
import com.codecool.ratemydrivinginstructorbackend.repository.SchoolRepository;
import com.codecool.ratemydrivinginstructorbackend.repository.model.School;
import com.codecool.ratemydrivinginstructorbackend.service.exception.InstructorCannotBeCreatedException;
import com.codecool.ratemydrivinginstructorbackend.service.exception.InstructorNotFoundException;
import com.codecool.ratemydrivinginstructorbackend.repository.InstructorRepository;
import com.codecool.ratemydrivinginstructorbackend.repository.model.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class InstructorService {

    private InstructorRepository instructorRepository;
    private SchoolRepository schoolRepository;
    private InstructorMapper instructorMapper;

    @Autowired
    public InstructorService(InstructorRepository instructorRepository, SchoolRepository schoolRepository, InstructorMapper instructorMapper) {
        this.instructorRepository = instructorRepository;
        this.schoolRepository = schoolRepository;
        this.instructorMapper = instructorMapper;
    }

    public List<InstructorDTO> getAllInstructors() {
        Set<Instructor> instructors = instructorRepository.getAllInstructors();
        return instructors.stream()
                .map(instructor -> instructorMapper.mapInstructorToInstructorDTO(instructor))
                .toList();
    }

    public InstructorDTO getInstructorById(int id) {
        return instructorRepository.getInstructorById(id)
                .map(instructor -> instructorMapper.mapInstructorToInstructorDTO(instructor))
                .orElseThrow(InstructorNotFoundException::new);
    }

    public boolean createInstructor(NewInstructorDTO newInstructorDTO) {
        int schoolId = newInstructorDTO.schoolId();
        Optional<School> optionalSchool = schoolRepository.getSchoolById(schoolId);

        if (optionalSchool.isPresent()) {
            Instructor instructor = instructorMapper.mapNewInstructorDTOToInstructor(newInstructorDTO, optionalSchool.get());
            return instructorRepository.addInstructor(instructor);
        } else {
            throw new InstructorCannotBeCreatedException(); //could be a concrete message in the exception
        }
    }

    //service should find the instructor, update and then the repo should save it in the database
    public boolean updateInstructor(int id, InstructorDTO instructorDTO) {
        return instructorRepository.getInstructorById(id)
                .map(existingInstructor -> instructorMapper.mapInstructorDTOToInstructor(instructorDTO))
                .map(instructorRepository::updateInstructor)
                .orElseThrow(InstructorNotFoundException::new);
    }

    public boolean deleteInstructor(int id) {
        if (!instructorRepository.deleteInstructor(id)) {
            throw new InstructorNotFoundException();
        }
        return true;
    }
}

