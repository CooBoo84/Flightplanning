package se.iths.flightplanning.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.flightplanning.entity.WorkerEntity;
import se.iths.flightplanning.service.WorkerService;

@RestController
@RequestMapping("staff")
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

    @GetMapping()
    public ResponseEntity<Iterable<WorkerEntity>> findAllStaff() {
        Iterable<WorkerEntity> allStaff = workerService.findAllStaff();
        return new ResponseEntity<>(allStaff, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteWorkerById(@PathVariable Long id) {
        workerService.deleteWorkerById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
