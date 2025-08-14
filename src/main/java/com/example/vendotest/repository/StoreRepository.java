package com.example.vendotest.repository;

import com.example.vendotest.domain.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
    Store findByUserIdAndId(Long userId, Long storeId);
}
