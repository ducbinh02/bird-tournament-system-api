package com.swp.doannc.service;

import com.swp.doannc.dto.RegisterBirdRequest;
import com.swp.doannc.dto.RegisterBirdResponse;
import com.swp.doannc.model.Bird;

import java.util.List;

public interface BirdService {
    List<Bird> getAllBird();

    Bird getBird(Long id);

    RegisterBirdResponse registerBird(Long userId, RegisterBirdRequest registerBirdRequest);
}
