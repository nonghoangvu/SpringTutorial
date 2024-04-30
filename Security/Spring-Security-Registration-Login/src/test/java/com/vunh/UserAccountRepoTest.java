package com.vunh;

import com.vunh.entity.UserAccount;
import com.vunh.repository.UserAccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserAccountRepoTest {
    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void getAll() {
        this.userAccountRepository.findAll().forEach(s -> {
            System.out.println(s.getId());
        });
    }
    @Test
    public void findByEmail(){
        System.out.println(this.userAccountRepository.findByEmail("caiyunin52@gmail.com").getPassword());
    }
}
