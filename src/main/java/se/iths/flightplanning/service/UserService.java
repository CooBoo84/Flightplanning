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

    public boolean deleteUserById(long id) {
        UserEntity foundUser = userRepository.findById(id);
        if (foundUser == null)
            return false;
        else {
            userRepository.deleteById(id);
            return true;
        }
    }

    public boolean deleteUserByEmail(String email) {
        UserEntity foundUser = userRepository.findByEmail(email);
        if (foundUser == null)
            return false;
        else {
            userRepository.deleteById(foundUser.getId());
            return true;
        }
    }


    public Optional<UserEntity> findUserById(Long id) {
        return userRepository.findById(id);
    }
}
