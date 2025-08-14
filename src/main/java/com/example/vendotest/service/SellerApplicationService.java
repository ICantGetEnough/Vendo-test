package com.example.vendotest.service;

import com.example.vendotest.domain.dto.SellerApplicationDto;
import com.example.vendotest.domain.entity.SellerApplication;
import com.example.vendotest.repository.SellerApplicationRepository;
import com.example.vendotest.util.mapper.SellerApplicationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SellerApplicationService {
    private final SellerApplicationRepository sellerApplicationRepository;
    private final SellerApplicationMapper sellerApplicationMapper;

    @Transactional(readOnly = true)
    public SellerApplicationDto.Response getById(Long id) {
        SellerApplication sellerApplication = sellerApplicationRepository.findById(id).orElse(null);
        return sellerApplicationMapper.toDto(sellerApplication);
    }

    @Transactional
    public SellerApplicationDto.Response createApp(SellerApplicationDto.Request request) {
        SellerApplication sellerApplication = sellerApplicationMapper.toEntity(request);
        sellerApplicationRepository.save(sellerApplication);
        return sellerApplicationMapper.toDto(sellerApplication);
    }

    public SellerApplication findById(Long id) {
        return sellerApplicationRepository.findById(id).orElse(null);
    }
}
