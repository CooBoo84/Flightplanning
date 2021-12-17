package se.iths.flightplanning.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.flightplanning.dto.CancellationProtectionDto;
import se.iths.flightplanning.service.CancellationProtectionServiceDto;

@RestController
@RequestMapping("cancellationprotections")
public class CancellationProtectionController {

    private final CancellationProtectionServiceDto cancellationProtectionServiceDto;

    public CancellationProtectionController(CancellationProtectionServiceDto cancellationProtectionServiceDto){
        this.cancellationProtectionServiceDto = cancellationProtectionServiceDto;
    }

    @PostMapping()
    public ResponseEntity<CancellationProtectionDto> createCancellationProtection(@RequestBody CancellationProtectionDto cancellationProtectionDto){
        CancellationProtectionDto createProtection = cancellationProtectionServiceDto.createProtection(cancellationProtectionDto);

        return new ResponseEntity<>(createProtection ,HttpStatus.CREATED);
    }

    @GetMapping()
    public  ResponseEntity<Iterable<CancellationProtectionDto>> findAllProtections(){
        Iterable<CancellationProtectionDto> allProtection = cancellationProtectionServiceDto.findAllProtections();
        return new ResponseEntity<>(allProtection, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteProtectionById(@PathVariable Long id) {
        cancellationProtectionServiceDto.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
