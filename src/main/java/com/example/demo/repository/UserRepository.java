package com.example.demo.repository;

import com.example.demo.entity.TbUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<TbUser, Long> {
    TbUser findByUsername(String username);
}
