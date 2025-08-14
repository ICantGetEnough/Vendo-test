package com.example.vendotest.service;

import com.example.vendotest.domain.dto.UserDto;
import com.example.vendotest.domain.entity.User;
import com.example.vendotest.repository.UserRepository;
import com.example.vendotest.util.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    private final SellerApplicationService sellerApplicationService;

    @Transactional(readOnly = true)
    public UserDto.Response getById(Long accountId) {
        var accountInformation = userRepository.findById(accountId).orElse(null);
        return userMapper.toDto(accountInformation);
    }

    @Transactional
    public UserDto.Response createUser(UserDto.Request request) {
        var account =  userMapper.toEntity(request);
        var savedAccount = userRepository.save(account);
        return userMapper.toDto(savedAccount);
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
