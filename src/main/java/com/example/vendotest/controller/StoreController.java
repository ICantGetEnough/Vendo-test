package com.example.vendotest.controller;

import com.example.vendotest.domain.dto.StoreDto;
import com.example.vendotest.domain.dto.UserDetailDto;
import com.example.vendotest.service.StoreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users/{userId}/stores")
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;

    @GetMapping("/id/{storeId}")
    public ResponseEntity<StoreDto.Response> getById(
            @PathVariable Long userId, @PathVariable Long storeId){
        var response = storeService.getById(userId, storeId);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<StoreDto.Response> createStore(
            @PathVariable Long userId, @RequestBody @Valid StoreDto.Request request){
        var response = storeService.createStore(userId, request);
        return ResponseEntity.ok(response);
    }
}
