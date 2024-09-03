package com.codecool.ratemydrivinginstructorbackend.service;

import com.codecool.ratemydrivinginstructorbackend.controller.dto.InstructorDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.dto.NewInstructorDTO;
import com.codecool.ratemydrivinginstructorbackend.repository.InstructorRepository;
import com.codecool.ratemydrivinginstructorbackend.repository.model.instructor.Instructor;
import com.codecool.ratemydrivinginstructorbackend.service.exception.InstructorNotFoundException;
import com.codecool.ratemydrivinginstructorbackend.service.exception.SchoolNotFoundException;
import com.codecool.ratemydrivinginstructorbackend.service.mapper.InstructorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class InstructorService {

    private InstructorRepository instructorRepository;
    private InstructorMapper instructorMapper;

    @Autowired
    public InstructorService(InstructorRepository instructorRepository, InstructorMapper instructorMapper) {
        this.instructorRepository = instructorRepository;
        this.instructorMapper = instructorMapper;
    }

    public void postNewInstructor(NewInstructorDTO newInstructorDTO) {
        instructorRepository.save(newInstructorDTO);
    }

    public void updateInstructor(Long instructorId, InstructorDTO instructorDTO) {
        Optional<Instructor> optionalInstructor = instructorRepository.findById(instructorId);
        optionalInstructor.flatMap(instructor -> {
            instructor.setFirstName(instructorDTO.firstName());
            instructor.setLastName(instructorDTO.lastName());
            instructor.setReviews(instructorDTO.reviews());
            instructor.setLicenseType(instructorDTO.licenseTypeSet());
            return Optional.of(instructorRepository.save(instructor));
        });
        if (optionalInstructor.isEmpty()) {
            throw new InstructorNotFoundException();
        }
    }

    public void deleteInstructor(Long instructorId) {
        instructorRepository.deleteById(instructorId);
    }

    public Set<InstructorDTO> getAllInstructors() {
        return instructorRepository.findAll().stream()
                .map(instructor -> instructorMapper.mapInstructorToInstructorDTO(instructor))
                .collect(Collectors.toUnmodifiableSet());
    }

    public InstructorDTO getInstructorById(Long instructorId) {
        Optional<Instructor> optionalInstructor = instructorRepository.findById(instructorId);
        if (optionalInstructor.isEmpty()) {
            throw new InstructorNotFoundException();
        }
        return instructorMapper.mapInstructorToInstructorDTO(optionalInstructor.get());
    }

    public Set<InstructorDTO> getInstructorsBySchoolId(Long schoolId) {
        Optional<Set<Instructor>> instructorEntitiesBySchoolId = instructorRepository.getAllInstructorsBySchoolId(schoolId);
        if (instructorEntitiesBySchoolId.isEmpty()) {
            throw new SchoolNotFoundException("No school find by the given I");
        }
        return instructorEntitiesBySchoolId.get().stream()
                .map(instructor -> instructorMapper.mapInstructorToInstructorDTO(instructor))
                .collect(Collectors.toUnmodifiableSet());
    }
}

