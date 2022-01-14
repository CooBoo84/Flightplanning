package se.iths.flightplanning.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import se.iths.flightplanning.dto.UserDto;
import se.iths.flightplanning.entity.UserEntity;
import se.iths.flightplanning.repository.UserRepository;
import se.iths.flightplanning.service.UserService;

import java.util.Optional;

@RestController
@RequestMapping("users")
@Validated
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private JmsTemplate jmsTemplate;

    private final UserService userService;
    Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @PostMapping("signup")
//    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) {
//        UserEntity createdUser = userService.createUser(user);
//        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
//    }
    @PostMapping("signup")
    public ResponseEntity<UserDto> createUser(@RequestBody UserEntity user) {
        UserDto createdUser = userService.createUserDto(user);
        jmsTemplate.convertAndSend("user", user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<UserEntity>> findUserById(@PathVariable Long id) {
        Optional<UserEntity> foundUser = userService.findUserById(id);
        return new ResponseEntity<>(foundUser, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Iterable<UserEntity>> findAllUsers() {
        Iterable<UserEntity> allUsers = userService.findAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }
}
