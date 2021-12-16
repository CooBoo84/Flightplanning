package se.iths.flightplanning.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import se.iths.flightplanning.entity.RoleEntity;
import se.iths.flightplanning.entity.UserEntity;
import se.iths.flightplanning.entity.WorkerEntity;
import se.iths.flightplanning.repository.AirplaneRepository;
import se.iths.flightplanning.repository.RoleRepository;
import se.iths.flightplanning.repository.RouteRepository;
import se.iths.flightplanning.repository.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserService(UserRepository userRepository , RoleRepository roleRepository){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public UserEntity createUser(UserEntity userEntity){
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        RoleEntity roleToAdd = roleRepository.findByRole("ROLE_USER");
        userEntity.addRole(roleToAdd);
        return userRepository.save(userEntity);
    }

    public void deleteUser(Long id){
        UserEntity foundUser = userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        userRepository.deleteById(foundUser.getId());
    }

    public Iterable<UserEntity> findAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity findUserById(Long id) {
        return userRepository.findUserEntityById(id);
    }

    public UserEntity findUserByUsername(String username) {
        return  userRepository.findUserEntityByUsername(username);
    }

    public UserEntity findUserByEmail(String email) {
        return  userRepository.findUserEntityByEmail(email);
    }

    public void deleteUserByUsername(String username) {
        UserEntity foundUser = userRepository.findUserEntityByUsername(username);
        userRepository.deleteById(foundUser.getId());
    }
}

