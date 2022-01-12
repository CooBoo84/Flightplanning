package se.iths.flightplanning.service;

import se.iths.flightplanning.dto.CustomerDto;

import java.util.List;

public interface CustomerServiceDto {

    CustomerDto createCustomer(CustomerDto customerDto);

    List<CustomerDto> findAllCustomers();

    void deleteCustomer(Long id);
}
