package se.iths.flightplanning.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import se.iths.flightplanning.entity.CustomerEntity;
import se.iths.flightplanning.repository.CustomerRepository;

@Service
class CustomerDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final CustomerRepository customerRepository;

    public CustomerDetailsService(CustomerRepository userRepository) {
        super();
        this.customerRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomerEntity userEntity = customerRepository.findByUsername(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException("Can't find user with username: " + "username");
        }
        return new CustomerPrincipal(userEntity);
    }

}
