package com.codecool.ratemydrivinginstructorbackend.service.instructor;

import com.codecool.ratemydrivinginstructorbackend.controller.instructor.instructorDTO.InstructorDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.instructor.instructorDTO.NewInstructorDTO;
import com.codecool.ratemydrivinginstructorbackend.repository.instructor.Instructor;
import com.codecool.ratemydrivinginstructorbackend.repository.instructor.InstructorRepository;
import com.codecool.ratemydrivinginstructorbackend.repository.school.School;
import com.codecool.ratemydrivinginstructorbackend.repository.school.SchoolRepository;
import com.codecool.ratemydrivinginstructorbackend.service.instructor.exception.InstructorNotFoundException;
import com.codecool.ratemydrivinginstructorbackend.service.review.ReviewMapper;
import com.codecool.ratemydrivinginstructorbackend.service.school.SchoolMapper;
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
    private final SchoolMapper schoolMapper;
    private final ReviewMapper reviewMapper;

    @Autowired
    public InstructorService(InstructorRepository instructorRepository, SchoolRepository schoolRepository, InstructorMapper instructorMapper, SchoolMapper schoolMapper, ReviewMapper reviewMapper) {
        this.instructorRepository = instructorRepository;
        this.schoolRepository = schoolRepository;
        this.instructorMapper = instructorMapper;
        this.schoolMapper = schoolMapper;
        this.reviewMapper = reviewMapper;
    }

    public InstructorDTO postNewInstructor(NewInstructorDTO newInstructorDTO) {
        Optional<School> optionalSchool = schoolRepository.findByPublicId(newInstructorDTO.schoolPublicId());
        School school = optionalSchool.orElseThrow(() -> new SchoolNotFoundException("Instructor cannot be created because school was not found"));
        Instructor instructor = instructorMapper.mapNewInstructorDTOToInstructor(newInstructorDTO, school);
        instructor.setPublicId(UUID.randomUUID());
        Instructor newInstructor = instructorRepository.save(instructor);
        return instructorMapper.mapInstructorToInstructorDTO(newInstructor, schoolMapper, reviewMapper);
    }

    public InstructorDTO updateInstructor(UUID instructorId, InstructorDTO instructorDTO) {
        Optional<Instructor> optionalInstructor = instructorRepository.findByPublicId(instructorId);

        if (optionalInstructor.isEmpty()) {
            throw new InstructorNotFoundException();
        }

        Instructor instructor = optionalInstructor.get();
        instructor.setFirstName(instructorDTO.firstName());
        instructor.setLastName(instructorDTO.lastName());
        instructor.setLicenseType(instructorDTO.licenseTypeSet());
        return instructorMapper.mapInstructorToInstructorDTO(instructor, schoolMapper, reviewMapper);
    }

    public void deleteInstructor(UUID publicId) {
        instructorRepository.deleteByPublicId(publicId);
    }

    public Set<InstructorDTO> getAllInstructors() {
        return instructorRepository.findAll().stream()
                .map(instructor -> instructorMapper.mapInstructorToInstructorDTO(instructor, schoolMapper, reviewMapper))
                .collect(Collectors.toUnmodifiableSet());
    }

    public InstructorDTO getInstructorById(UUID publicId) {
        Optional<Instructor> optionalInstructor = instructorRepository.findByPublicId(publicId);
        if (optionalInstructor.isEmpty()) {
            throw new InstructorNotFoundException();
        }
        return instructorMapper.mapInstructorToInstructorDTO(optionalInstructor.get(), schoolMapper, reviewMapper);
    }

    public Set<InstructorDTO> getInstructorsBySchoolId(UUID schoolPublicId) {
        Set<Instructor> instructorsBySchoolId = instructorRepository.getAllInstructorsBySchoolPublicId(schoolPublicId);

        if (instructorsBySchoolId.isEmpty()) {
            throw new SchoolNotFoundException("School was not found");
        }
        return instructorsBySchoolId.stream()
                .map(instructor -> instructorMapper.mapInstructorToInstructorDTO(instructor, schoolMapper, reviewMapper))
                .collect(Collectors.toUnmodifiableSet());
    }

    public int getNumberOfInstructors() {
        return (int) instructorRepository.count();
    }
}

