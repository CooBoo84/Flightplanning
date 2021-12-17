package se.iths.flightplanning.service;

import org.springframework.stereotype.Service;
import se.iths.flightplanning.dto.WorkerDto;
import se.iths.flightplanning.mappers.WorkerMapper;
import se.iths.flightplanning.repository.WorkerRepository;

import java.util.List;

@Service
public class WorkerService implements WorkerServiceDto{

    private final WorkerRepository workerRepository;
    private final WorkerMapper workerMapper;

    public WorkerService(WorkerRepository workerRepository, WorkerMapper workerMapper) {
        this.workerRepository = workerRepository;
        this.workerMapper = workerMapper;
    }

    @Override
    public WorkerDto createWorker(WorkerDto workerDto){
        return workerMapper.mapp(workerRepository.save(workerMapper.mapp(workerDto)));
    }

    @Override
    public List<WorkerDto> findAllWorkers() {
        return workerMapper.mapp(workerRepository.findAll());
    }

    @Override
    public void deleteWorkerById(Long id) {
        workerRepository.deleteById(id);
    }
}
