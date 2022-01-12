package se.iths.flightplanning.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import se.iths.flightplanning.entity.UserEntity;
import se.iths.flightplanning.exception.EmptyListException;
import se.iths.flightplanning.exception.ResourceNotFoundException;
import se.iths.flightplanning.service.UserService;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("signup")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) {
        UserEntity createdUser = userService.createUser(user);

        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<Iterable<UserEntity>> findAllUsers() {
        Iterable<UserEntity> allUsers = userService.findAllUsers();
        if (allUsers.iterator().hasNext())
            return new ResponseEntity<>(allUsers, HttpStatus.OK);
        else
            throw new EmptyListException("Users list is empty.");
    }

    @GetMapping("/username")
    public ResponseEntity<UserEntity> findUserByUsername(@RequestParam String username) {
        UserEntity foundUser = userService.findUserByUsername(username);
        if (foundUser == null) {
            throw new ResourceNotFoundException("User with username :" + username + " could not be found.");
        }
        return new ResponseEntity<>(foundUser, HttpStatus.OK);
    }

    @DeleteMapping("")
    public ResponseEntity<Void> deleteUserByUsername(@RequestParam String username) {
        userService.deleteUserByUsername(username);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}

