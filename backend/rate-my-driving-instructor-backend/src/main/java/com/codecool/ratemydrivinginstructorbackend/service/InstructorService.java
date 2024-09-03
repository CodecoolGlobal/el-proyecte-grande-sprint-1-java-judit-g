package com.codecool.ratemydrivinginstructorbackend.service;

import com.codecool.ratemydrivinginstructorbackend.controller.dto.InstructorDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.dto.NewInstructorDTO;
import com.codecool.ratemydrivinginstructorbackend.repository.InstructorRepository;
import com.codecool.ratemydrivinginstructorbackend.repository.model.instructor.InstructorEntity;
import com.codecool.ratemydrivinginstructorbackend.service.exception.InstructorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        Optional<InstructorEntity> optionalInstructor = instructorRepository.findById(instructorId);
        optionalInstructor.flatMap(instructorEntity -> {
            instructorEntity.setFirstName(instructorDTO.firstName());
            instructorEntity.setLastName(instructorDTO.lastName());
            instructorEntity.setReviews(instructorDTO.reviews());
            instructorEntity.setLicenseType(instructorDTO.licenseTypeSet());
            return Optional.of(instructorRepository.save(instructorEntity));
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
                .map(instructorEntity -> instructorMapper.mapInstructorToInstructorDTO(instructorEntity))
                .collect(Collectors.toUnmodifiableSet());
    }

    public InstructorDTO getInstructorById(Long instructorId) {
        Optional<InstructorEntity> optionalInstructor = instructorRepository.findById(instructorId);
        if (optionalInstructor.isEmpty()) {
            throw new InstructorNotFoundException();
        }
        return instructorMapper.mapInstructorToInstructorDTO(optionalInstructor.get());
    }

    public Set<InstructorDTO> getInstructorsBySchoolId(Long schoolId) {
        Optional<Set<InstructorEntity>> instructorEntitiesBySchoolId = instructorRepository.getAllInstructorsBySchoolId(schoolId);
        if (instructorEntitiesBySchoolId.isEmpty()) {
            throw new SchoolNotFoundException();
        }
        return instructorEntitiesBySchoolId.get().stream()
                .map(instructorEntity -> instructorMapper.mapInstructorToInstructorDTO(instructorEntity))
                .collect(Collectors.toUnmodifiableSet());
    }
}

