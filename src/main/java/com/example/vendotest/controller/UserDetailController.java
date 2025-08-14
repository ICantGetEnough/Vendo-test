package com.example.vendotest.controller;

import com.example.vendotest.domain.dto.UserDetailDto;
import com.example.vendotest.service.UserDetailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users/{userId}/userDetails")
@RequiredArgsConstructor
public class UserDetailController {
    private final UserDetailService userDetailService;

    @GetMapping("/id/{userDetailId}")
     public ResponseEntity<UserDetailDto.Response> getById(
            @PathVariable Long userId, @PathVariable Long userDetailId) {
        return ResponseEntity.ok(userDetailService.getById(userId, userDetailId));
    }

    @PostMapping
    public ResponseEntity<UserDetailDto.Response> createUserDetail(
            @PathVariable Long userId, @Valid @RequestBody UserDetailDto.Request request){
        var response = userDetailService.createUserDetail(userId, request);
        return ResponseEntity.ok(response);
    }
}
