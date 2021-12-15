package se.iths.flightplanning.service;

import org.springframework.stereotype.Service;
import se.iths.flightplanning.entity.AirplaneEntity;
import se.iths.flightplanning.entity.RouteEntity;
import se.iths.flightplanning.entity.UserEntity;
import se.iths.flightplanning.entity.WorkerEntity;
import se.iths.flightplanning.repository.AirplaneRepository;
import se.iths.flightplanning.repository.RouteRepository;
import se.iths.flightplanning.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RouteRepository routeRepository;

    public UserService(UserRepository userRepository, RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
        this.userRepository = userRepository;
    }

    public UserEntity createUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
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



    //public Optional<UserEntity> findUserById(Long id) {
    //    return userRepository.findById(id);
    //}
}
