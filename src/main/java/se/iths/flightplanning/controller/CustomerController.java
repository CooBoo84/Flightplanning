package se.iths.flightplanning.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.flightplanning.dto.CustomerDto;
import se.iths.flightplanning.service.CustomerServiceDto;

@RestController
@RequestMapping("customers")
public class CustomerController {

    private final CustomerServiceDto customerServiceDto;

    public CustomerController(CustomerServiceDto customerServiceDto) {
        this.customerServiceDto = customerServiceDto;
    }

    @PostMapping()
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto) {
        CustomerDto createdCustomer = customerServiceDto.createCustomer(customerDto);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<Iterable<CustomerDto>> findAllUsers() {
        Iterable<CustomerDto> allUsers = customerServiceDto.findAllCustomers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

}
