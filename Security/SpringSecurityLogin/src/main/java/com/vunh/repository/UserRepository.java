package com.vunh.repository;

import com.vunh.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("FROM User WHERE username LIKE :username")
    Optional<User> findByUsername(@Param("username") String username);
}
