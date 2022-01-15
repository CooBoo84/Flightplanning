package se.iths.flightplanning.service;

import org.springframework.data.jpa.repository.JpaRepository;
import se.iths.flightplanning.dto.UserDto;
import se.iths.flightplanning.entity.UserEntity;

import java.util.List;

public interface UserServiceDto  {
    UserDto createUserDto(UserEntity user);

   // Iterable<UserEntity> findAllUsers();

   Iterable<UserDto> findAllUsersDTO();
}
