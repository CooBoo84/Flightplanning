package se.iths.flightplanning.mappers;

import org.springframework.stereotype.Component;
import se.iths.flightplanning.dto.CancellationProtectionDto;
import se.iths.flightplanning.entity.CancellationProtectionEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CancellationProtectionMapper {

    public CancellationProtectionMapper() {
    }

    public CancellationProtectionDto mapp(CancellationProtectionEntity cancellationProtectionEntity) {
        return new CancellationProtectionDto(cancellationProtectionEntity.getId(), cancellationProtectionEntity.getProtection());
    }

    public CancellationProtectionEntity mapp(CancellationProtectionDto cancellationProtectionDto) {
        return new CancellationProtectionEntity(cancellationProtectionDto.getId(), cancellationProtectionDto.getProtection());
    }

    public Optional<CancellationProtectionDto> mapp(Optional<CancellationProtectionEntity> optionalCancellationProtectionEntity) {
        if(optionalCancellationProtectionEntity.isEmpty())
            return Optional.empty();
        return Optional.of(mapp(optionalCancellationProtectionEntity.get()));
    }

    public List<CancellationProtectionDto> mapp(List<CancellationProtectionEntity> all) {
        return all
                .stream()
                .map(this::mapp)
                .collect(Collectors.toList());
    }

}
