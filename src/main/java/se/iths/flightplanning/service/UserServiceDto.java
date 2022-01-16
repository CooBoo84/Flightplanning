package se.iths.flightplanning.service;

import se.iths.flightplanning.dto.UserDto;

public interface UserServiceDto {

    Iterable<UserDto> findAllUsersDTO();
}
