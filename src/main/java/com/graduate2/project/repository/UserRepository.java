package com.graduate2.project.repository;

import com.graduate2.project.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email); //이메일을 통해 생성된 사용자인지 체크함.
}
