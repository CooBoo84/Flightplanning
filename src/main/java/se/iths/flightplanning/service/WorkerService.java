package se.iths.flightplanning.service;

import org.springframework.stereotype.Service;
import se.iths.flightplanning.entity.WorkerEntity;
import se.iths.flightplanning.repository.WorkerRepository;

@Service
public class WorkerService{

    private final WorkerRepository workerRepository;

    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    public WorkerEntity createWorker(WorkerEntity workerEntity){
        return workerRepository.save(workerEntity);
    }

    public Iterable<WorkerEntity> findAllWorkers() {
        return workerRepository.findAll();
    }

    public void deleteById(Long id) {
        workerRepository.deleteById(id);
    }
}
