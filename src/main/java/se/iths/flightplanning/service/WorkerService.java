package se.iths.flightplanning.service;

import org.springframework.stereotype.Service;
import se.iths.flightplanning.entity.AirplaneEntity;
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

    public void deleteWorkerById(Long id) {
        WorkerEntity foundAirplane = workerRepository.findAllByAirplane_Id(id);
        workerRepository.deleteById(foundAirplane.getId());
    }



    public Optional<WorkerEntity> findWorkerById(Long id) {
        return workerRepository.findById(id);
    }

}
