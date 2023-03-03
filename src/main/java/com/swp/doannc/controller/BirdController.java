package com.swp.doannc.controller;

import com.swp.doannc.dto.RegisterBirdRequest;
import com.swp.doannc.dto.RegisterBirdResponse;
import com.swp.doannc.model.Bird;
import com.swp.doannc.model.User;
import com.swp.doannc.security.service.AuthService;
import com.swp.doannc.service.BirdService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/bird")
public class BirdController {
    private final AuthService authService;
    private final BirdService birdService;
    @GetMapping
    ResponseEntity<Bird> getBird(@Valid @RequestParam Long id) {
        final Bird bird = birdService.getBird(id);
        return ResponseEntity.ok(bird);
    }

    @GetMapping("/all")
    ResponseEntity<List<Bird>> getAllBird() {
        return ResponseEntity.ok(birdService.getAllBird());
    }

    @PostMapping("/register")
    ResponseEntity<RegisterBirdResponse> registerBird(Authentication authentication, @Valid @RequestBody RegisterBirdRequest registerBirdRequest) {
        final User user = authService.findByEmail(authentication.getName());
        final RegisterBirdResponse registerBirdResponse = birdService.registerBird(user.getId(), registerBirdRequest);
        return ResponseEntity.ok(registerBirdResponse);
    }
}
