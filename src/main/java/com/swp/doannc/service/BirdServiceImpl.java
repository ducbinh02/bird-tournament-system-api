package com.swp.doannc.service;

import com.swp.doannc.dto.RegisterBirdRequest;
import com.swp.doannc.dto.RegisterBirdResponse;
import com.swp.doannc.mapper.BirdMapper;
import com.swp.doannc.model.Bird;
import com.swp.doannc.repository.BirdRepository;
import com.swp.doannc.util.GeneralMessageAccessor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BirdServiceImpl implements BirdService {

    private static final String REGISTRATION_SUCCESSFUL = "registration_successful";
    private final BirdRepository birdRepository;
    private final GeneralMessageAccessor generalMessageAccessor;

    @Override
    public List<Bird> getAllBird() {
        return birdRepository.findAll();
    }

    @Override
    public Bird getBird(Long id) {
        return birdRepository.getReferenceById(id);
    }

    @Override
    public RegisterBirdResponse registerBird(Long userId, RegisterBirdRequest registerBirdRequest){

        final Bird bird = BirdMapper.INSTANCE.convertToBird(registerBirdRequest);

        bird.setOwnerId(userId);

        birdRepository.save(bird);

        final String message = generalMessageAccessor.getMessage(null, REGISTRATION_SUCCESSFUL, registerBirdRequest.getName());
        return new RegisterBirdResponse(message);


    }
}
