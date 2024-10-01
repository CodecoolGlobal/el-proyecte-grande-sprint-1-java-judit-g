package com.codecool.ratemydrivinginstructorbackend.service.configuration;

import com.codecool.ratemydrivinginstructorbackend.service.instructor.InstructorMapper;
import com.codecool.ratemydrivinginstructorbackend.service.review.ReviewMapper;
import com.codecool.ratemydrivinginstructorbackend.service.appuser.AppUserMapper;
import com.codecool.ratemydrivinginstructorbackend.service.school.SchoolMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfiguration {

    private SchoolMapper schoolMapper = new SchoolMapper();

    @Bean
    public AppUserMapper reviewerMapper() {
        return new AppUserMapper();
    }

    @Bean
    public ReviewMapper reviewMapper() {
        return new ReviewMapper(reviewerMapper());
    }

    @Bean
    public InstructorMapper instructorMapper(ReviewMapper reviewMapper) {
        InstructorMapper instructorMapper = new InstructorMapper();
        instructorMapper.setReviewMapper(reviewMapper);
        instructorMapper.setSchoolMapper(this.schoolMapper);
        return  instructorMapper;
    }

    @Bean
    public SchoolMapper schoolMapper(InstructorMapper instructorMapper) {
        schoolMapper.setInstructorMapper(instructorMapper);
        return schoolMapper;
    }

}
