package com.swp.doannc.service;

import com.swp.doannc.dto.*;
import com.swp.doannc.mapper.UserMapper;
import com.swp.doannc.model.SortBy;
import com.swp.doannc.model.User;
import com.swp.doannc.repository.UserRepository;
import com.swp.doannc.util.GeneralMessageAccessor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private static final String DISABLE_SUCCESSFUL = "disable_user_successful";

    private static final String UPDATE_SUCCESSFUL = "update_user_successful";

    private final UserRepository userRepository;

    private final UserValidationService userValidationService;

    private final GeneralMessageAccessor generalMessageAccessor;

    @Override
    public User getUser(Long id) {
        userValidationService.checkExisted(id);
        return userRepository.getReferenceById(id);
    }

    @Override
    public UpdateUserResponse updateProfile(Long id, UpdateProfileRequest updateProfileRequest) {
        final UpdateUserRequest updateUserRequest = UserMapper.INSTANCE.convertToUpdateUserRequest(updateProfileRequest);
        updateUserRequest.setUserId(id);
        return this.updateUser(updateUserRequest);
    }

    @Override
    public UpdateUserResponse updateUser(UpdateUserRequest updateUserRequest) {
        final Long id = updateUserRequest.getUserId();
        userValidationService.checkExisted(id);

        final User user = userRepository.getReferenceById(id);

        final String name = updateUserRequest.getName();
        final String address = updateUserRequest.getAddress();
        final String phone = updateUserRequest.getPhone();

        if (name != null && !name.isBlank()) user.setName(name);
        if (address != null && !address.isBlank()) user.setAddress(address);
        if (phone != null && !phone.isBlank()) user.setPhone(phone);

        userRepository.save(user);

        final String message = generalMessageAccessor.getMessage(null, UPDATE_SUCCESSFUL, name);

        return new UpdateUserResponse(message);
    }

    @Override
    public List<User> searchUser(SearchUserRequest searchUserRequest) {
//        final String keyword = searchUserRequest.getKeyword();
        final int pageSize = searchUserRequest.getPageSize();
        final int pageNum = searchUserRequest.getPageNum();
        final String order = searchUserRequest.getOrder();
        Sort sort = Sort.by(order);
        if (searchUserRequest.getSort().equals(SortBy.ASCENDING)) {
            sort = sort.ascending();
        } else {
            sort = sort.descending();
        }
        final Pageable pageable = PageRequest.of(pageNum, pageSize, sort);
        final Page<User> page = userRepository.findAll(pageable);
        return page.toList();
    }

    @Override
    public DisableUserResponse disableUser(Long id) {
        userValidationService.checkExisted(id);

        final User user = userRepository.getReferenceById(id);
        user.setEnable(false);
        userRepository.save(user);

        final String email = user.getEmail();
        final String message = generalMessageAccessor.getMessage(null, DISABLE_SUCCESSFUL, email);

        return new DisableUserResponse(message);
    }


}
