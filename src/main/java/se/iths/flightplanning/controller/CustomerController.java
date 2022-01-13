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

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("signup")
    public ResponseEntity<CustomerEntity> createCustomer(@RequestBody CustomerEntity customerEntity) {
        CustomerEntity createdCustomer = customerService.createCustomer(customerEntity);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

//    @GetMapping()
//    public ResponseEntity<Iterable<CustomerEntity>> findAllCustomers() {
//        Iterable<CustomerEntity> allUsers = customerEntity.findAllCustomers();
//        return new ResponseEntity<>(allUsers, HttpStatus.OK);
//    }
//
//    @DeleteMapping("{id}")
//    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
//        customerEntity.deleteCustomer(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

}
