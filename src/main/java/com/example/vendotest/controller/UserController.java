package com.example.vendotest.controller;

import com.example.vendotest.domain.dto.UserDto;
import com.example.vendotest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/id/{userId}")
    public ResponseEntity<UserDto.Response> getById(@PathVariable Long userId) {
        UserDto.Response response = userService.getById(userId);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<UserDto.Response> createUser(
            @RequestBody UserDto.Request request){
        var response = userService.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
