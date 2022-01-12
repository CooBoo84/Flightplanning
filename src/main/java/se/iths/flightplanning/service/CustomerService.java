package se.iths.flightplanning.service;

import org.springframework.stereotype.Service;
import se.iths.flightplanning.dto.CustomerDto;
import se.iths.flightplanning.entity.CustomerEntity;
import se.iths.flightplanning.entity.RoleEntity;
import se.iths.flightplanning.mappers.CustomerMapper;
import se.iths.flightplanning.repository.CustomerRepository;
import se.iths.flightplanning.repository.RoleRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CustomerService implements CustomerServiceDto{

    private final CustomerRepository customerRepository;
    private final RoleRepository roleRepository;
    private final CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository, RoleRepository roleRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.roleRepository = roleRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        RoleEntity roleToAdd = roleRepository.findByRole("ROLE_ADMIN");
        return customerMapper.mapp(customerRepository.save(customerMapper.mapp(customerDto)));
    }
    @Override
    public List<CustomerDto> findAllCustomers () {
        return customerMapper.mapp(customerRepository.findAll());
    }

    @Override
    public void deleteCustomer(Long id) {
        CustomerEntity foundCustomer = customerRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        customerRepository.deleteById(foundCustomer.getId());
    }

}


