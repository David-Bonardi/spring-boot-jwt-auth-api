package com.david.authapi.repository;

import com.david.authapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
//Parte de ORM gera SQL automaticamente
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
