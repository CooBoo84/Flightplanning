package se.iths.flightplanning.service;

import org.springframework.stereotype.Service;
import se.iths.flightplanning.entity.RoleEntity;
import se.iths.flightplanning.entity.CustomerEntity;
import se.iths.flightplanning.mappers.CustomerMapper;
import se.iths.flightplanning.mappers.RoleMapper;
import se.iths.flightplanning.repository.CustomerRepository;
import se.iths.flightplanning.repository.RoleRepository;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RoleRepository roleRepository;
    private final CustomerMapper customerMapper;
    private final RoleMapper roleMapper;

    public CustomerService(CustomerRepository customerRepository, RoleRepository roleRepository, CustomerMapper customerMapper, RoleMapper roleMapper) {
        this.customerRepository = customerRepository;
        this.roleRepository = roleRepository;
        this.customerMapper = customerMapper;
        this.roleMapper = roleMapper;
    }

    public CustomerEntity createCustomer(CustomerEntity customerEntity) {
        RoleEntity roleToAdd = roleRepository.findByRole("ROLE_ADMIN");
//        RoleDto roleDto = roleMapper.mapp(roleToAdd);
        customerEntity.addRole(roleToAdd);
        return customerRepository.save(customerEntity);
//        return customerMapper.mapp(customerRepository.save(customerMapper.mapp(customerDto)));
    }

//    public List<CustomerEntity> findAllCustomers () {
//        return customerMapper.mapp(customerRepository.findAll());
//    }
//
//
//    public void deleteCustomer(Long id) {
//        se.iths.flightplanning.entity.CustomerEntity foundCustomer = customerRepository.findById(id).orElseThrow(EntityNotFoundException::new);
//        customerRepository.deleteById(foundCustomer.getId());
//    }

}


