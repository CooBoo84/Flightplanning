package se.iths.flightplanning.service;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import se.iths.flightplanning.entity.RoleEntity;
import se.iths.flightplanning.entity.UserEntity;
import se.iths.flightplanning.repository.RoleRepository;
import se.iths.flightplanning.repository.UserRepository;

import java.util.HashSet;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

//    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public UserEntity createUser(UserEntity userEntity) {
//        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        RoleEntity roleToAdd = roleRepository.findByRole("ROLE_ADMIN");
        userEntity.addRole(roleToAdd);
        return userRepository.save(userEntity);
    }
    public Iterable<UserEntity> findAllUsers() {
        return userRepository.findAll();
    }

}
