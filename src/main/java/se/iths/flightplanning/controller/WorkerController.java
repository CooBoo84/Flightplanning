package se.iths.flightplanning.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.flightplanning.dto.WorkerDto;
import se.iths.flightplanning.service.WorkerServiceDto;

@RestController
@RequestMapping("staff")
public class WorkerController {

    private final WorkerServiceDto workerServiceDto;

    public WorkerController(WorkerServiceDto workerServiceDto) {
        this.workerServiceDto = workerServiceDto;
    }

    @PostMapping()
    public ResponseEntity<WorkerDto> createWorker(@RequestBody WorkerDto workerDto) {
        WorkerDto createdWorker = workerServiceDto.createWorker(workerDto);
        return new ResponseEntity<>(createdWorker, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<Iterable<WorkerDto>> findAllStaff() {
        Iterable<WorkerDto> allStaff = workerServiceDto.findAllWorkers();
        return new ResponseEntity<>(allStaff, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteWorkerById(@PathVariable Long id) {
        workerServiceDto.deleteWorkerById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
