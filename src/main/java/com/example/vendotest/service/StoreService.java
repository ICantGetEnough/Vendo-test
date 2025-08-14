package com.example.vendotest.service;

import com.example.vendotest.domain.dto.StoreDto;
import com.example.vendotest.domain.entity.Store;
import com.example.vendotest.repository.StoreRepository;
import com.example.vendotest.util.mapper.StoreMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final UserService userService;

    private final StoreMapper storeMapper;
    private final StoreRepository storeRepository;

    public StoreDto.Response getById(Long userId, Long storeId) {
        var store = findById(userId, storeId);
        return storeMapper.toDto(store);
    }

    public StoreDto.Response createStore(Long userId, StoreDto.Request request) {
        var user = userService.findById(userId);

        var store = storeMapper.toEntity(request);
        store.setUser(user);

        var savedStore = storeRepository.save(store);
        return storeMapper.toDto(savedStore);
    }

    public Store findById(Long  userId, Long storeId) {
        return storeRepository.findByUserIdAndId(userId, storeId);
    }
}
