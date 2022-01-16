package se.iths.flightplanning.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import se.iths.flightplanning.dto.WorkerDto;

import org.springframework.web.server.ResponseStatusException;
import se.iths.flightplanning.entity.RouteEntity;

import se.iths.flightplanning.entity.WorkerEntity;
import se.iths.flightplanning.service.WorkerService;

@RestController
@RequestMapping("workers")
public class WorkerController {

    private final WorkerService workerService;

    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @PostMapping()
    public ResponseEntity<WorkerEntity> createWorker(@RequestBody WorkerEntity workerEntity) {
        WorkerEntity createdWorker = workerService.createWorker(workerEntity);
        return new ResponseEntity<>(createdWorker, HttpStatus.CREATED);
    }

//    @GetMapping()
//    public ResponseEntity<Iterable<WorkerEntity>> findAllWorkers() {
//        Iterable<WorkerEntity> allStaff = workerService.findAllWorkers();
//        return new ResponseEntity<>(allStaff, HttpStatus.OK);
//    }

    @GetMapping()
    public ResponseEntity<Iterable<WorkerDto>> findAllWorkersDto() {
        Iterable<WorkerDto> allStaff = workerService.findAllWorkersDto();
        return new ResponseEntity<>(allStaff, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public WorkerEntity findWorkerById(@PathVariable Long id) {
        return workerService.getWorkerById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Id " + id + " not found."));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteWorkerById(@PathVariable Long id) {
        workerService.deleteWorkerById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
