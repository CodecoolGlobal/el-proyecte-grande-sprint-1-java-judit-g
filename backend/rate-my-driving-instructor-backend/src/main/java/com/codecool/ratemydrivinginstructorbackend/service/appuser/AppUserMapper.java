package com.codecool.ratemydrivinginstructorbackend.service.appuser;

import com.codecool.ratemydrivinginstructorbackend.controller.appuser.appuserDTO.NewAppUserDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.appuser.appuserDTO.AppUserDTO;
import com.codecool.ratemydrivinginstructorbackend.repository.appuser.AppUser;

public class AppUserMapper {

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
}
