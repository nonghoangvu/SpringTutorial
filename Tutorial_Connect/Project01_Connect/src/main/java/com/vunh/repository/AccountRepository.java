package com.vunh.repository;

import com.vunh.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>, PagingAndSortingRepository<Account, Integer> {
    @Query("SELECT a FROM Account a WHERE a.username = :username")
    Account findByUsername(@Param("username") String username);
}
