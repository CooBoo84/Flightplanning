package se.iths.flightplanning.service;

import org.springframework.stereotype.Service;
import se.iths.flightplanning.entity.WorkerEntity;
import se.iths.flightplanning.repository.WorkerRepository;

import java.util.Optional;

@Service
public class WorkerService {

    private final WorkerRepository workerRepository;

    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    public WorkerEntity createWorker(WorkerEntity workerEntity){
        return workerRepository.save(workerEntity);
    }

    public Iterable<WorkerEntity> findAllStaff() {
        return workerRepository.findAll();
    }

    public boolean deleteWorkerById(long id) {
        WorkerEntity foundWorker = workerRepository.findById(id);
        if (foundWorker == null)
            return false;
        else {
            workerRepository.deleteById(id);
            return true;
        }
    }

    public Optional<WorkerEntity> findWorkerById(Long id) {
        return workerRepository.findById(id);
    }

}
