package se.iths.flightplanning.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import se.iths.flightplanning.entity.User;
import se.iths.flightplanning.repository.UserRepository;

@Service
class LoppisUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public LoppisUserDetailsService(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Can't find user with username: " + "username");
        }
        return new LoppisUserPrincipal(user);
    }

}
