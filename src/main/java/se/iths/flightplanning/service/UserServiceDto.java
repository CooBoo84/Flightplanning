package se.iths.flightplanning.service;

import se.iths.flightplanning.dto.UserDto;
import se.iths.flightplanning.entity.UserEntity;

public interface UserServiceDto {
    UserDto createUser(UserDto userDto);

    Iterable<UserEntity> findAllUsers();
}
