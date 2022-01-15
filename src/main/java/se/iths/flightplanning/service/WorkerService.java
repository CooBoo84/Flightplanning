package se.iths.flightplanning.service;

import org.springframework.stereotype.Service;
import se.iths.flightplanning.entity.RouteEntity;
import se.iths.flightplanning.entity.WorkerEntity;
import se.iths.flightplanning.repository.WorkerRepository;

import java.util.Optional;

@Service
public class WorkerService{

    private final WorkerRepository workerRepository;

    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    public WorkerEntity createWorker(WorkerEntity workerEntity){
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
}
