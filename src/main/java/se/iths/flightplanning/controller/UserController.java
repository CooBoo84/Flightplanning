package se.iths.flightplanning.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.flightplanning.entity.AirplaneEntity;
import se.iths.flightplanning.entity.UserEntity;
import se.iths.flightplanning.exception.NoRecordFoundException;
import se.iths.flightplanning.service.UserService;


@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) { this.userService = userService;}

    @PostMapping()
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) {
        UserEntity createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<Iterable<UserEntity>> findAllUsers() {
        Iterable<UserEntity> allUsers = userService.findAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserEntity> findUserById(@PathVariable Long id) {
        UserEntity foundUser = userService.findUserById(id);
        if (foundUser == null) {
            throw new NoRecordFoundException();
        }
        return new ResponseEntity<>(foundUser, HttpStatus.OK);
    }

    @GetMapping("/username")
    public ResponseEntity<UserEntity> findUserByUsername(@RequestParam String username) {
        UserEntity foundUser = userService.findUserByUsername(username);
        if (foundUser == null) {
            throw new NoRecordFoundException();
        }
        return new ResponseEntity<>(foundUser, HttpStatus.OK);
    }

    @GetMapping("/email")
    public ResponseEntity<UserEntity> findUserByEmail(@RequestParam String email) {
        UserEntity foundUser = userService.findUserByEmail(email);
        if (foundUser == null) {
            throw new NoRecordFoundException();
        }
        return new ResponseEntity<>(foundUser, HttpStatus.OK);
    }
/*

    @GetMapping("/name")
    public ResponseEntity<AirplaneEntity> findAirplaneByName(@RequestParam String name) {
        AirplaneEntity foundAirplane = airplaneService.findByName(name);
        if (foundAirplane == null) {
            throw new NoRecordFoundException();
        }
        return new ResponseEntity<>(foundAirplane, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteAnAirplaneById(@PathVariable Long id) {
        airplaneService.deleteAirplaneById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
*/


}
