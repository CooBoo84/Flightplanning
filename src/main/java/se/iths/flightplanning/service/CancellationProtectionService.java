package se.iths.flightplanning.service;

import org.springframework.stereotype.Service;
import se.iths.flightplanning.dto.CancellationProtectionDto;
import se.iths.flightplanning.mappers.CancellationProtectionMapper;
import se.iths.flightplanning.repository.CancellationProtectionRepository;

import java.util.List;


@Service
public class CancellationProtectionService implements CancellationProtectionServiceDto {

    private final CancellationProtectionRepository cancellationProtectionRepository;
    private final CancellationProtectionMapper cancellationProtectionMapper;

    public CancellationProtectionService(CancellationProtectionRepository cancellationProtectionRepository, CancellationProtectionMapper cancellationProtectionMapper){
        this.cancellationProtectionRepository = cancellationProtectionRepository;
        this.cancellationProtectionMapper = cancellationProtectionMapper;
    }

    @Override
    public CancellationProtectionDto createProtection(CancellationProtectionDto cancellationProtectionDto){
        return cancellationProtectionMapper.mapp(cancellationProtectionRepository.save(cancellationProtectionMapper.mapp(cancellationProtectionDto)));
    }

    @Override
    public List<CancellationProtectionDto> findAllProtections(){
        return cancellationProtectionMapper.mapp(cancellationProtectionRepository.findAll());
    }

    @Override
    public void deleteById(Long id) {
        cancellationProtectionRepository.deleteById(id);
    }
}
