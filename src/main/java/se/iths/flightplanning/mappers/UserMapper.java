package se.iths.flightplanning.mappers;

import org.springframework.stereotype.Component;
import se.iths.flightplanning.dto.UserDto;
import se.iths.flightplanning.entity.UserEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    public UserDto mapp(UserEntity userEntity) {
        return new UserDto(userEntity.getId(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getEmail(),
                userEntity.getTelephone(),
                userEntity.getUsername(),
                userEntity.getPassword());
    }

    public UserEntity mapp(UserDto userDto) {
        return new UserEntity(
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail(),
                userDto.getTelephone(),
                userDto.getUsername(),
                userDto.getPassword());
    }

    public Optional<UserDto> mapp(Optional<UserEntity> optionalUserEntity) {
        if(optionalUserEntity.isEmpty())
            return Optional.empty();
        return Optional.of(mapp(optionalUserEntity.get()));
    }

    public List<UserDto> mapp(List<UserEntity> all) {
        return all
                .stream()
                .map(this::mapp)
                .collect(Collectors.toList());
    }
}
