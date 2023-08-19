package com.app.testtaskjavaback.service;

import com.app.testtaskjavaback.model.Users;
import org.springframework.http.ResponseEntity;

import java.util.Map;
import java.util.Optional;

public interface UserService {
    ResponseEntity<Object> save(Users user);

    ResponseEntity<Object> findById(long id);

    ResponseEntity<Object> updateUser(long id);

}
