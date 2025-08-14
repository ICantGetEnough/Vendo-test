package com.example.vendotest.repository;

import com.example.vendotest.domain.entity.SellerApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerApplicationRepository extends JpaRepository<SellerApplication, Long> {

}
