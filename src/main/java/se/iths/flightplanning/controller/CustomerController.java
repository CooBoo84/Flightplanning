package se.iths.flightplanning.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.flightplanning.entity.CustomerEntity;
import se.iths.flightplanning.service.CustomerService;


@RestController
@RequestMapping("customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) { this.customerService = customerService;}

    @PostMapping()
    public ResponseEntity<CustomerEntity> createUser(@RequestBody CustomerEntity user) {
        CustomerEntity createdUser = customerService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<Iterable<CustomerEntity>> findAllUsers() {
        Iterable<CustomerEntity> allUsers = customerService.findAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

}
