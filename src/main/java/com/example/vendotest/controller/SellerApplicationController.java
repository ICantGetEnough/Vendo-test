package com.example.vendotest.controller;

import com.example.vendotest.domain.dto.SellerApplicationDto;
import com.example.vendotest.service.SellerApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/application-forms")
@RequiredArgsConstructor
public class SellerApplicationController {
    private final SellerApplicationService sellerApplicationService;

    @GetMapping("/id/{id}")
    public ResponseEntity<SellerApplicationDto.Response> getById(@PathVariable Long id) {
        var applicationForm = sellerApplicationService.getById(id);
        return ResponseEntity.ok(applicationForm);
    }

    @PostMapping
    public ResponseEntity<SellerApplicationDto.Response> createApp(
            @RequestBody SellerApplicationDto.Request request) {
        var applicationForm = sellerApplicationService.createApp(request);
        return ResponseEntity.ok(applicationForm);
    }
}
