package com.app.testtaskjavaback.service;

import com.app.testtaskjavaback.exception.UserExistingEmailException;
import com.app.testtaskjavaback.exception.UserNotFoundException;
import com.app.testtaskjavaback.model.Users;
import com.app.testtaskjavaback.repository.UserRepository;
import com.app.testtaskjavaback.response.ResponseHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    //@Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity<Object> findById(long id) {
        Optional<Users> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("User does not exist");
        }
        return ResponseHandler.responseBuilder("serched user", HttpStatus.OK, user.get());
    }

    @Override
    public ResponseEntity<Object> save(Users user) {

        String userEmail = user.getEmail();
        // Падает с NoSuchElementException т.к. ведётся поиск по email, которого нет в БД
        String userInDataBaseEmail = userRepository.findByEmail(user.getEmail()).get().getEmail();

        if (userEmail.equalsIgnoreCase(userInDataBaseEmail)) {
            throw new UserExistingEmailException("there is user with the same email");
        }
        long id = userRepository.save(user).getId();
        return ResponseHandler.responseBuilder("user was saved", HttpStatus.OK, id);
    }

    @Override
    public ResponseEntity<Object> updateUser(long id) {

        if (userRepository.findById(id).isEmpty()) {
            throw new UserNotFoundException("User does not exist");
        }

        Users user = userRepository.findById(id).get();

        Map<String, String> response = new HashMap<>();
        response.put("id", user.getId().toString());
        response.put("previous status", user.getStatus());

        if (user.getStatus().equalsIgnoreCase("offline")) {
            user.setStatus("online");
            response.put("current status", user.getStatus());
        } else {
            user.setStatus("offline");
            response.put("current status", user.getStatus());
        }
        userRepository.save(user);
        return ResponseHandler.responseBuilder("user was updated", HttpStatus.OK, response);
    }
}
