package se.iths.flightplanning.service;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import se.iths.flightplanning.dto.CustomerDto;
import se.iths.flightplanning.entity.RoleEntity;
import se.iths.flightplanning.entity.CustomerEntity;
import se.iths.flightplanning.mappers.CustomerMapper;
import se.iths.flightplanning.repository.RoleRepository;
import se.iths.flightplanning.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService implements CustomerServiceDto{

    private final CustomerRepository customerRepository;
    private final RoleRepository roleRepository;
    private final CustomerMapper customerMapper;
//    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

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
}



   /* public CustomerEntity createUser(CustomerEntity customerEntity) {
//        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        RoleEntity roleToAdd = roleRepository.findByRole("ROLE_ADMIN");
       // customerEntity.addRole(roleToAdd);
        return customerRepository.save(customerEntity);
    }
    public Iterable<CustomerEntity> findAllUsers() {
        return customerRepository.findAll();
    }
*/


