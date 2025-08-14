package com.example.vendotest.repository;

import com.example.vendotest.domain.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailRepository extends JpaRepository<UserDetail, Long> {
    UserDetail findByUserIdAndId(Long userId, Long userId1);
}
