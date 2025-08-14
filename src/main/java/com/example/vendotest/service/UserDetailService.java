package com.example.vendotest.service;

import com.example.vendotest.domain.dto.UserDetailDto;
import com.example.vendotest.domain.entity.UserDetail;
import com.example.vendotest.repository.UserDetailRepository;
import com.example.vendotest.util.mapper.UserDetailMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailService {
    private final UserService userService;

    private final UserDetailRepository userDetailRepository;
    private final UserDetailMapper userDetailMapper;

    public UserDetailDto.Response getById(Long userId, Long userDetailId) {
        UserDetail userDetail = userDetailRepository.findByUserIdAndId(userId, userDetailId);
        return userDetailMapper.toDto(userDetail);
    }

    public UserDetailDto.Response createUserDetail(Long userId,
                                                   UserDetailDto.Request request) {
        var user = userService.findById(userId);

        var userDetail = userDetailMapper.toEntity(request);
        userDetail.setUser(user);

        var savedUserDetail = userDetailRepository.save(userDetail);
        return userDetailMapper.toDto(savedUserDetail);
    }
}
