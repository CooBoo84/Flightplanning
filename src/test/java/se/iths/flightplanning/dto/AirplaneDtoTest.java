package se.iths.flightplanning.dto;

import org.junit.jupiter.api.Test;
import se.iths.flightplanning.entity.AirplaneEntity;
import se.iths.flightplanning.mappers.AirplaneMapper;

import static org.junit.jupiter.api.Assertions.*;

class AirplaneDtoTest {

    private AirplaneMapper airplaneMapper = new AirplaneMapper();

    @Test
    public void when_converting_AiplaneEntity_to_AirplaneDto_then_correct() {

        AirplaneEntity airplane = new AirplaneEntity();
        airplane.setAirplaneName("Jumbo 200");
        airplane.setNumberOfSeat(50);
        airplane.setNumberOfStaff(3);

        AirplaneDto airplaneDto = airplaneMapper.mapp(airplane);

        assertEquals(airplane.getId(), airplaneDto.getId());
        assertEquals(airplane.getAirplaneName(), airplaneDto.getAirplaneName());
        assertEquals(airplane.getNumberOfSeat(), airplaneDto.getNumberOfSeat());
        assertEquals(airplane.getNumberOfStaff(), airplaneDto.getNumberOfStaff());



//        PostDto postDto = modelMapper.map(post, PostDto.class);
//        assertEquals(post.getId(), postDto.getId());
//        assertEquals(post.getTitle(), postDto.getTitle());
//        assertEquals(post.getUrl(), postDto.getUrl());
    }

    @Test
    public void when_converting_AiplaneDto_to_AirplaneEntity_then_correct() {

        AirplaneDto airplaneDto = new AirplaneDto();
        airplaneDto.setAirplaneName("Jumbo 200");
        airplaneDto.setNumberOfSeat(12);
        airplaneDto.setNumberOfStaff(4);

        AirplaneEntity airplane = airplaneMapper.mapp(airplaneDto);

        assertEquals(airplaneDto.getId(), airplane.getId());
        assertEquals(airplaneDto.getAirplaneName(), airplane.getAirplaneName());
        assertEquals(airplaneDto.getNumberOfSeat(), airplane.getNumberOfSeat());
        assertEquals(airplaneDto.getNumberOfStaff(), airplane.getNumberOfStaff());
    }

}