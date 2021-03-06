package se.iths.flightplanning.service;

import org.springframework.stereotype.Service;

import se.iths.flightplanning.dto.WorkerDto;
import se.iths.flightplanning.entity.WorkerEntity;
import se.iths.flightplanning.mappers.WorkerMapper;
import se.iths.flightplanning.repository.WorkerRepository;

import java.util.Optional;

@Service
public class WorkerService implements WorkerServiceDto {

    private final WorkerRepository workerRepository;
    private final WorkerMapper workerMapper;

    public WorkerService(WorkerRepository workerRepository, WorkerMapper workerMapper) {
        this.workerRepository = workerRepository;
        this.workerMapper = workerMapper;
    }

    public WorkerEntity createWorker(WorkerEntity workerEntity) {
        return workerRepository.save(workerEntity);
    }

    public Optional<WorkerEntity> getWorkerById(Long id) {
        return workerRepository.findById(id);
    }

    public Iterable<WorkerEntity> findAllWorkers() {
        return workerRepository.findAll();
    }

    public void deleteWorkerById(Long id) {
        workerRepository.deleteById(id);
    }

    @Override
    public Iterable<WorkerDto> findAllWorkersDto() {
        return workerMapper.mapp(workerRepository.findAll());
    }
}
