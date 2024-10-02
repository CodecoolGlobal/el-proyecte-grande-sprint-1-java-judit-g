package com.codecool.ratemydrivinginstructorbackend.service.appuser;

import com.codecool.ratemydrivinginstructorbackend.controller.appuser.appuserDTO.AppUserForAdminDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.appuser.appuserDTO.NewAppUserDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.appuser.appuserDTO.AppUserDTO;
import com.codecool.ratemydrivinginstructorbackend.repository.appuser.AppUser;
import com.codecool.ratemydrivinginstructorbackend.service.review.ReviewMapper;
import lombok.Setter;

public class AppUserMapper {

    private ReviewMapper reviewMapper;

    public AppUserMapper(ReviewMapper reviewMapper) {
        this.reviewMapper = reviewMapper;
    }

    public AppUser mapNewAppUserDTOToAppUser(NewAppUserDTO newAppUserDTO) {
        return new AppUser(
                newAppUserDTO.username()
        );
    }

    public AppUserDTO mapAppUserToAppUserDTO(AppUser appUser) {
        return appUser == null ? null : new AppUserDTO(
                appUser.getPublicId(),
                appUser.getUsername()
        );
    }

    public AppUserForAdminDTO mapAppUserToAppUserForAdminDTO(AppUser appUser) {
        return appUser == null ? null : new AppUserForAdminDTO(
                appUser.getPublicId(),
                appUser.getUsername(),
                reviewMapper.mapReviewsToReviewForAdminDTO(appUser.getReviews())
        );
    }
}
