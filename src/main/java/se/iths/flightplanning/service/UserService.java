package se.iths.flightplanning.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import se.iths.flightplanning.dto.RoleDto;
import se.iths.flightplanning.dto.UserDto;
import se.iths.flightplanning.entity.RoleEntity;
import se.iths.flightplanning.entity.UserEntity;
import se.iths.flightplanning.mappers.RoleMapper;
import se.iths.flightplanning.mappers.UserMapper;
import se.iths.flightplanning.repository.RoleRepository;
import se.iths.flightplanning.repository.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class UserService implements UserServiceDto{

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;
    private final RoleMapper roleMapper;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserService(UserRepository userRepository, RoleRepository roleRepository, UserMapper userMapper, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.roleMapper = roleMapper;
    }

//    public UserEntity createUser(UserEntity userEntity) {
//        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
//        RoleEntity roleToAdd = roleRepository.findByRole("ROLE_USER");
//        userEntity.addRole(roleToAdd);
//        return userRepository.save(userEntity);
//    }

    public void deleteUser(Long id) {
        UserEntity foundUser = userRepository.findById(id).orElseThrow(EntityNotFoundException::new);  //Optional förhindrar nullpointExceptions
        userRepository.deleteById(foundUser.getId());
    }

    public Optional<UserEntity> findUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public UserDto createUserDto(UserEntity user) {
//        RoleEntity roleToAdd = roleRepository.findByRole("ROLE_USER");
//        RoleDto addRole = roleMapper.mapp(roleToAdd);
//
//        userDto.addRole(addRole);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        RoleEntity roleToAdd = roleRepository.findByRole("ROLE_USER");
        user.addRole(roleToAdd);
        userRepository.save(user);

        UserDto userDto = userMapper.mapp(user);

        return userDto;


    }

    public Iterable<UserEntity> findAllUsers() {
        return userRepository.findAll();
    }

}
