package com.app.testtaskjavaback.repository;

import com.app.testtaskjavaback.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findById(Long id);

    Optional<Users> findByEmail(String email);
}
