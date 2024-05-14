package com.example.parcial2.repositorio;

import com.example.parcial2.model.UserE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositorio extends JpaRepository<UserE, Long>{
    Optional<UserE> findByEmail(String email);
}
