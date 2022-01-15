package se.iths.flightplanning;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import se.iths.flightplanning.controller.AirplaneController;
import se.iths.flightplanning.dto.AirplaneDto;
import se.iths.flightplanning.repository.AirplaneRepository;
import se.iths.flightplanning.service.AirplaneServiceDto;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AirplaneController.class)
@AutoConfigureMockMvc
@EnableWebMvc
public class AirplaneTests extends WebSecurityConfigurerAdapter {

    @MockBean
    AirplaneServiceDto airplaneServiceDto;

    @MockBean
    AirplaneDto airplaneDto;

    @MockBean
    AirplaneController airplaneController;

    @MockBean
    private AirplaneRepository airplaneRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAirplaneControllerInitializedCorrectly() {
        assertThat(airplaneController).isNotNull();
    }

    @Test
    void testReturnAllAirplanesSuccess() throws Exception {

        when(airplaneServiceDto.findAllPlanes()).thenReturn(List.of(new AirplaneDto("Model-X", 222, 22)));

        var result = mockMvc.perform(MockMvcRequestBuilders.get("/airplanes")
                        .with(SecurityMockMvcRequestPostProcessors.user("kungen").roles("ADMIN"))
                        .with(csrf())
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();
        assertThat(result.getResponse().getStatus()).isEqualTo(200);
    }

    @Test
    void testReturnOneAirplaneSuccess() throws Exception {

        when(airplaneServiceDto.getAirplaneById(1L)).thenReturn(Optional.of(new AirplaneDto( "Model-Y", 333, 33)));

        var result = mockMvc.perform(MockMvcRequestBuilders.get("/airplanes/{id}", "1")
                        .with(SecurityMockMvcRequestPostProcessors.user("kungen").roles("ADMIN"))
                        .with(csrf())
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();
        assertThat(result.getResponse().getStatus()).isEqualTo(200);
    }

    @Test
    public void testCreateAirplaneSuccess() throws Exception {
        AirplaneDto airplane = new AirplaneDto("Model-Z", 333, 33);
        Gson gson = new Gson();
        when(airplaneServiceDto.createPlane(airplane)).thenReturn(airplane);

        var result = mockMvc.perform(MockMvcRequestBuilders.post("/airplanes")
                        .with(SecurityMockMvcRequestPostProcessors.user("kungen").roles("ADMIN"))
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gson.toJson(airplane))
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();
        assertThat(result.getResponse().getStatus()).isEqualTo(200);
    }

    @Test
    void testDeleteAirplaneSuccess() throws Exception {
        new AirplaneDto("Model-Z", 333, 33);
        airplaneServiceDto.deleteById(1L);
        Mockito.verify(airplaneServiceDto).deleteById(1L);
    }

    @Test
    public void findNoLoginRejected() throws Exception {
        when(airplaneServiceDto.getAirplaneById(1L)).thenReturn(Optional.of(new AirplaneDto( "Model-101", 100, 10)));
        mockMvc.perform(get("/airplanes/1"))
                .andDo(print())
                .andExpect(status().isUnauthorized());

        System.out.println("------------------- AirplaneControllerTest findNoLoginRejected ------------------------------");
    }

}
