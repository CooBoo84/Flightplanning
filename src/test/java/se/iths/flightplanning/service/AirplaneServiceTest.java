package se.iths.flightplanning.service;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import se.iths.flightplanning.dto.AirplaneDto;
import se.iths.flightplanning.entity.AirplaneEntity;
import se.iths.flightplanning.mappers.AirplaneMapper;
import se.iths.flightplanning.repository.AirplaneRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AirplaneServiceTest {

    @Mock
    private AirplaneRepository airplaneRepository;

    @Mock
    private AirplaneServiceDto airplaneServiceDto;

    @Mock
    private AirplaneMapper airplaneMapper;

    @Autowired
    @InjectMocks
    private AirplaneService airplaneService;
    private AirplaneEntity airplaneOne;
    private AirplaneEntity airplaneTwo;
    List<AirplaneEntity> airplaneList;

    @BeforeEach
    public void setUp() {
        airplaneList = new ArrayList<>();
        airplaneOne = new AirplaneEntity("air-one", 50,5);
        airplaneTwo = new AirplaneEntity("air-two", 30,3);
        airplaneList.add(airplaneOne);
        airplaneList.add(airplaneTwo);

        AirplaneDto airplaneOneDto = airplaneMapper.mapp(airplaneOne);
        AirplaneDto airplaneTwoDto = airplaneMapper.mapp(airplaneTwo);
    }

    @AfterEach
    public void tearDown() {
        airplaneOne = airplaneTwo = null;
        airplaneList = null;
    }


    @Test
    void createPlane_should_return_created_airplane() {
        when(airplaneRepository.save(any())).thenReturn(airplaneOne);
        airplaneService.createPlane(airplaneOne);
        verify(airplaneRepository,times(1)).save(any());
    }

    @Test
    void findAllPlanes_should_return_all_airplanes() {
        airplaneRepository.save(airplaneOne);
        when(airplaneRepository.findAll()).thenReturn(airplaneList);
        Iterable<AirplaneEntity> allAirplanes =airplaneService.findAllPlanes();
        assertEquals(allAirplanes,airplaneList);
        verify(airplaneRepository,times(1)).save(airplaneOne);
        verify(airplaneRepository,times(1)).findAll();
    }

    @Test
    void given_Id_getAirplaneById_should_return_airplane_of_that_Id() {
        Mockito.when(airplaneRepository.findById(0L)).thenReturn(Optional.ofNullable(airplaneOne));
        assertThat((airplaneService.getAirplaneById(airplaneOne.getId()))).get().isEqualTo(airplaneOne);
    }

    @Test
    void given_Id_deleteById_should_delete_the_airplane_of_that_Id() {
        long airplaneId = 0;
        airplaneRepository.deleteById(0L);
        verify(airplaneRepository, times(1)).deleteById(eq(airplaneId));
    }

    @Test
    void findAllPlanesDTO_returns_all_airplanes_dtos() {
        AirplaneDto airplaneOneDto = airplaneMapper.mapp(airplaneOne);
        AirplaneDto airplaneTwoDto = airplaneMapper.mapp(airplaneTwo);
        Iterable<AirplaneDto> airplaneDtoList = airplaneService.findAllPlanesDTO();
        assertEquals(airplaneService.findAllPlanesDTO(), airplaneDtoList);
    }
}