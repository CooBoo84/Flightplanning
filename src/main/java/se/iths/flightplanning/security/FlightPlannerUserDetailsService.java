package se.iths.flightplanning.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import se.iths.flightplanning.entity.UserEntity;
import se.iths.flightplanning.repository.UserRepository;

@Service
public class FlightPlannerUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public FlightPlannerUserDetailsService(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username);

        if (userEntity == null) {
            System.out.println("Can´t find user with username: " + username);
        }

        return new FlightPlannerUserPrincipal(userEntity);
    }
}
