package com.swp.doannc.service;

import com.swp.doannc.dto.*;
import com.swp.doannc.model.User;

import java.util.List;

public interface UserService {
    User getUser(Long id);

    UpdateUserResponse updateUser(UpdateUserRequest updateUserRequest);

    UpdateUserResponse updateProfile(Long userId, UpdateProfileRequest updateUserRequest);

    List<User> searchUser(SearchUserRequest searchUserRequest);

    DisableUserResponse disableUser(Long id);

}
