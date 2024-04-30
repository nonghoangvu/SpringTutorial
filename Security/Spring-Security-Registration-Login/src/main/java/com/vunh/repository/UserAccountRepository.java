package com.vunh.repository;

import com.vunh.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Integer> {
    @Query("FROM UserAccount WHERE email LIKE :email")
    UserAccount findByEmail(@Param("email") String email);
}
