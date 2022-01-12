package se.iths.flightplanning.mappers;

import org.springframework.stereotype.Component;
import se.iths.flightplanning.dto.AirplaneDto;
import se.iths.flightplanning.dto.WorkerDto;
import se.iths.flightplanning.entity.AirplaneEntity;
import se.iths.flightplanning.entity.WorkerEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class WorkerMapper {
    public WorkerMapper() {
    }

    public WorkerDto mapp(WorkerEntity workerEntity) {
        return new WorkerDto(
                workerEntity.getPilot(),
                workerEntity.getFlightAttendant());
    }

    public WorkerEntity mapp(WorkerDto workerDto) {
        return new WorkerEntity(
                workerDto.getPilot(),
                workerDto.getFlightAttendant());
    }

    public Optional<WorkerDto> mapp(Optional<WorkerEntity> optionalWorkerEntity) {
        if(optionalWorkerEntity.isEmpty())
            return Optional.empty();
        return Optional.of(mapp(optionalWorkerEntity.get()));
    }

    public List<WorkerDto> mapp(List<WorkerEntity> all) {
        return all
                .stream()
                .map(this::mapp)
                .collect(Collectors.toList());
    }
}
