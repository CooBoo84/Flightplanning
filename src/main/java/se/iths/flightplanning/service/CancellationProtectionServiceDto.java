package se.iths.flightplanning.service;

import se.iths.flightplanning.dto.CancellationProtectionDto;

import java.util.List;

public interface CancellationProtectionServiceDto {

    List<CancellationProtectionDto> findAllProtections();

    CancellationProtectionDto createProtection(CancellationProtectionDto cancellationProtectionDto);

    void deleteById(Long id);

}
