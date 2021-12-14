package se.iths.flightplanning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
import org.springframework.stereotype.Repository;
=======
import org.springframework.jms.core.JmsTemplate;
>>>>>>> d705337efabc22873f15df12bfde23dfd2219f3f
import org.springframework.web.bind.annotation.*;
import se.iths.flightplanning.entity.UserEntity;
import se.iths.flightplanning.service.UserService;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private JmsTemplate jmsTemplate;

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("signup")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) {
        UserEntity createdUser = userService.createUser(user);
<<<<<<< HEAD

=======
        jmsTemplate.convertAndSend("user", createdUser);
>>>>>>> d705337efabc22873f15df12bfde23dfd2219f3f
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<UserEntity>> findUserById(@PathVariable Long id) {
        Optional<UserEntity> foundUser = userService.findUserById(id);
        return new ResponseEntity<>(foundUser, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<UserEntity>> findAllUsers() {
        Iterable<UserEntity> allUsers = userService.findAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }
}
