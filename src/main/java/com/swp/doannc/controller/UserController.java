package com.swp.doannc.controller;

import com.swp.doannc.dto.*;
import com.swp.doannc.model.User;
import com.swp.doannc.security.service.AuthService;
import com.swp.doannc.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final AuthService authService;

    private final UserService userService;

    @PutMapping("/profile")
    ResponseEntity<UpdateUserResponse> updateProfile(Authentication authentication, @Valid @RequestBody UpdateProfileRequest updateProfileRequest) {
        final User user = authService.findByEmail(authentication.getName());
        final UpdateUserResponse result = userService.updateProfile(user.getId(), updateProfileRequest);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/profile")
    ResponseEntity<User> getProfile(Authentication authentication) {
        final User user = authService.findByEmail(authentication.getName());
        return ResponseEntity.ok(user);
    }

    @GetMapping
    ResponseEntity<User> getUser(@Valid @RequestParam Long id) {
        final User user = userService.getUser(id);
        return ResponseEntity.ok(user);
    }

//    @PostMapping
//    ResponseEntity<User> createUser(Authentication authentication) {
//        final User user = authService.findByEmail(authentication.getName());
//        return ResponseEntity.ok(user);
//    }

    @PutMapping
    ResponseEntity<UpdateUserResponse> updateUser(@Valid @RequestBody UpdateUserRequest updateUserRequest) {
        final UpdateUserResponse result = userService.updateUser(updateUserRequest);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping
    ResponseEntity<DisableUserResponse> disableUser(@Valid @RequestParam Long id) {
        final DisableUserResponse result = userService.disableUser(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/search")
    ResponseEntity<List<User>> searchUser(@Valid @RequestBody SearchUserRequest searchUserRequest) {
        final List<User> result = userService.searchUser(searchUserRequest);
        return ResponseEntity.ok(result);
    }

}
