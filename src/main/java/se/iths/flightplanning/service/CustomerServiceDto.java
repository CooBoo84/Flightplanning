package se.iths.flightplanning.service;

import se.iths.flightplanning.entity.CustomerEntity;

import java.util.List;

public interface CustomerServiceDto {

    CustomerEntity createCustomer(CustomerEntity customerDto);

    List<CustomerEntity> findAllCustomers();

    void deleteCustomer(Long id);
}
