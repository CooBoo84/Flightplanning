package se.iths.flightplanning.service;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import se.iths.flightplanning.entity.RoleEntity;
import se.iths.flightplanning.entity.CustomerEntity;
import se.iths.flightplanning.repository.RoleRepository;
import se.iths.flightplanning.repository.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RoleRepository roleRepository;

//    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public CustomerService(CustomerRepository customerRepository, RoleRepository roleRepository) {
        this.customerRepository = customerRepository;
        this.roleRepository = roleRepository;
    }

    public CustomerEntity createUser(CustomerEntity customerEntity) {
//        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
//        RoleEntity roleToAdd = roleRepository.findByRole("ROLE_ADMIN");
       // customerEntity.addRole(roleToAdd);
        return customerRepository.save(customerEntity);
    }
    public Iterable<CustomerEntity> findAllUsers() {
        return customerRepository.findAll();
    }

}
