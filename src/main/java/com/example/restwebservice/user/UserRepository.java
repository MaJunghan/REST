package com.example.restwebservice.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // DB와 관련된 빈이다
public interface UserRepository extends JpaRepository<User, Integer> {
}
