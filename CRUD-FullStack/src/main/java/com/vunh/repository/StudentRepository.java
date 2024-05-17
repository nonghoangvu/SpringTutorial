package com.vunh.repository;

import com.vunh.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query("FROM Student WHERE fullName LIKE %:q%")
    Page<Student> findAll(Pageable pageable, @Param("q") String q);
}
