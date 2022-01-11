package se.iths.flightplanning.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import se.iths.flightplanning.entity.CustomerEntity;
import se.iths.flightplanning.repository.CustomerRepository;

import javax.transaction.Transactional;

@Service
public class FlightPlannerCustomerDetailsService implements UserDetailsService {

    private CustomerRepository customerRepository;

    public FlightPlannerCustomerDetailsService(CustomerRepository customerRepository) {
        super();
        this.customerRepository = customerRepository;
    }


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomerEntity customer = customerRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return FlightPlannerCustomerPrincipal.build(customer);
    }
}
