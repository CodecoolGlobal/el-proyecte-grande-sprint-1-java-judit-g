package com.codecool.ratemydrivinginstructorbackend.service.configuration;

import com.codecool.ratemydrivinginstructorbackend.service.instructor.InstructorMapper;
import com.codecool.ratemydrivinginstructorbackend.service.review.ReviewMapper;
import com.codecool.ratemydrivinginstructorbackend.service.appuser.AppUserMapper;
import com.codecool.ratemydrivinginstructorbackend.service.school.SchoolMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class MapperConfiguration {

    @Bean
    public AppUserMapper appUserMapper(@Lazy ReviewMapper reviewMapper) {
        return new AppUserMapper(reviewMapper);
    }

    @Bean
    public ReviewMapper reviewMapper(@Lazy AppUserMapper appUserMapper, @Lazy InstructorMapper instructorMapper) {
        return new ReviewMapper(appUserMapper, instructorMapper);
    }

    @Bean
    public InstructorMapper instructorMapper(SchoolMapper schoolMapper, ReviewMapper reviewMapper) {
        InstructorMapper instructorMapper = new InstructorMapper();
        instructorMapper.setSchoolMapper(schoolMapper);
        instructorMapper.setReviewMapper(reviewMapper);
        return instructorMapper;
    }

    @Bean
    public SchoolMapper schoolMapper(@Lazy InstructorMapper instructorMapper) {
        SchoolMapper schoolMapper = new SchoolMapper();
        schoolMapper.setInstructorMapper(instructorMapper);
        return schoolMapper;
    }
}
