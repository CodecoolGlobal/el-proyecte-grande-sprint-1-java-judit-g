package com.codecool.ratemydrivinginstructorbackend.service.instructor;

import com.codecool.ratemydrivinginstructorbackend.controller.instructor.instructorDTO.InstructorDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.instructor.instructorDTO.NewInstructorDTO;
import com.codecool.ratemydrivinginstructorbackend.repository.instructor.Instructor;
import com.codecool.ratemydrivinginstructorbackend.repository.instructor.InstructorRepository;
import com.codecool.ratemydrivinginstructorbackend.repository.school.School;
import com.codecool.ratemydrivinginstructorbackend.repository.school.SchoolRepository;
import com.codecool.ratemydrivinginstructorbackend.service.instructor.exception.InstructorNotFoundException;
import com.codecool.ratemydrivinginstructorbackend.service.school.exception.SchoolNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class InstructorService {

    private final InstructorRepository instructorRepository;
    private final SchoolRepository schoolRepository;
    private final InstructorMapper instructorMapper;

    @Autowired
    public InstructorService(InstructorRepository instructorRepository, SchoolRepository schoolRepository, InstructorMapper instructorMapper) {
        this.instructorRepository = instructorRepository;
        this.schoolRepository = schoolRepository;
        this.instructorMapper = instructorMapper;
    }

    public InstructorDTO postNewInstructor(NewInstructorDTO newInstructorDTO) {
        Optional<School> optionalSchool = schoolRepository.findByPublicId(newInstructorDTO.schoolPublicId());
        School school = optionalSchool.orElseThrow(() -> new SchoolNotFoundException("Instructor cannot be created because school was not found"));
        Instructor instructor = instructorMapper.mapNewInstructorDTOToInstructor(newInstructorDTO, school);
        Instructor newInstructor = instructorRepository.save(instructor);
        return instructorMapper.mapInstructorToInstructorDTO(newInstructor);
    }

    public InstructorDTO updateInstructor(UUID instructorId, InstructorDTO instructorDTO) {
        Optional<Instructor> optionalInstructor = instructorRepository.findInstructorByPublicId(instructorId);

        if (optionalInstructor.isEmpty()) {
            throw new InstructorNotFoundException();
        }

        Instructor instructor = optionalInstructor.get();
        instructor.setFirstName(instructorDTO.firstName());
        instructor.setLastName(instructorDTO.lastName());
        instructor.setLicenseType(instructorDTO.licenseTypeSet());
        return instructorMapper.mapInstructorToInstructorDTO(instructor);
    }

    public void deleteInstructor(UUID publicId) {
        instructorRepository.deleteByPublicId(publicId);
    }

    public Set<InstructorDTO> getAllInstructors() {
        return instructorRepository.findAll().stream()
                .map(instructorMapper::mapInstructorToInstructorDTO)
                .collect(Collectors.toUnmodifiableSet());
    }

    public InstructorDTO getInstructorById(UUID publicId) {
        Optional<Instructor> optionalInstructor = instructorRepository.findInstructorByPublicId(publicId);
        if (optionalInstructor.isEmpty()) {
            throw new InstructorNotFoundException();
        }
        return instructorMapper.mapInstructorToInstructorDTO(optionalInstructor.get());
    }

    public Set<InstructorDTO> getInstructorsBySchoolId(UUID schoolPublicId) {
        Set<Instructor> instructorsBySchoolId = instructorRepository.getAllInstructorsBySchoolPublicId(schoolPublicId);

        if (instructorsBySchoolId.isEmpty()) {
            throw new SchoolNotFoundException("School was not found");
        }
        return instructorsBySchoolId.stream()
                .map(instructorMapper::mapInstructorToInstructorDTO)
                .collect(Collectors.toUnmodifiableSet());
    }
}

