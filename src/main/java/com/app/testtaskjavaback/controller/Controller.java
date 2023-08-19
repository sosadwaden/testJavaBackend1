package com.app.testtaskjavaback.controller;

import com.app.testtaskjavaback.model.Users;
import com.app.testtaskjavaback.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class Controller {

    //@Autowired
    UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUser(@PathVariable int id) {
        return userService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Object> addUser(@RequestBody Users user) {
        return userService.save(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateStatus(@PathVariable long id) {
        return userService.updateUser(id);
    }
}
