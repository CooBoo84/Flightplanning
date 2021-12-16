package se.iths.flightplanning.mappers;

import org.springframework.stereotype.Component;
import se.iths.flightplanning.dto.RoleDto;
import se.iths.flightplanning.entity.RoleEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class RoleMapper {
    public RoleMapper() {
    }

    public RoleDto mapp(RoleEntity roleEntity){
        return new RoleDto(roleEntity.getId(),roleEntity.getRole());
    }
    public RoleEntity mapp(RoleDto roleDto){
        return new RoleEntity(roleDto.getRole());
    }
    public Optional<RoleDto> mapp(Optional<RoleEntity> optionalRoleEntity){
        if(optionalRoleEntity.isEmpty())
            return Optional.empty();
            return Optional.of(mapp(optionalRoleEntity.get()));
    }

    public List<RoleDto> mapp(List<RoleEntity> all){
        return all
                .stream()
                .map(this::mapp)
                .collect(Collectors.toList());
    }
}
