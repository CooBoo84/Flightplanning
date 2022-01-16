package se.iths.flightplanning;

import com.google.gson.Gson;
import org.junit.Test;
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
import se.iths.flightplanning.entity.AirplaneEntity;
import se.iths.flightplanning.repository.AirplaneRepository;
import se.iths.flightplanning.service.AirplaneService;

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
    AirplaneService airplaneService;

    @MockBean
    AirplaneEntity airplaneDto;

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
    public void testReturnAllAirplanesSuccess() throws Exception {

        when(airplaneService.findAllPlanes()).thenReturn(List.of(new AirplaneEntity("Model-X", 222, 22)));

        var result = mockMvc.perform(MockMvcRequestBuilders.get("/airplanes")
                        .with(SecurityMockMvcRequestPostProcessors.user("kungen").roles("ADMIN"))
                        .with(csrf())
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();
        assertThat(result.getResponse().getStatus()).isEqualTo(200);
    }

    @Test
    public void testReturnOneAirplaneSuccess() throws Exception {

        when(airplaneService.getAirplaneById(1L)).thenReturn(Optional.of(new AirplaneEntity( "Model-Y", 333, 33)));

        var result = mockMvc.perform(MockMvcRequestBuilders.get("/airplanes/{id}", "1")
                        .with(SecurityMockMvcRequestPostProcessors.user("kungen").roles("ADMIN"))
                        .with(csrf())
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();
        assertThat(result.getResponse().getStatus()).isEqualTo(200);
    }

    @Test
    public void testCreateAirplaneSuccess() throws Exception {
        AirplaneEntity airplane = new AirplaneEntity("Model-Z", 333, 33);
        Gson gson = new Gson();
        when(airplaneService.createPlane(airplane)).thenReturn(airplane);

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
    public void testDeleteAirplaneSuccess() throws Exception {
        new AirplaneEntity("Model-Z", 333, 33);
        airplaneService.deleteById(1L);
        Mockito.verify(airplaneService).deleteById(1L);
    }

    @Test
    public void findNoLoginRejected() throws Exception {
        when(airplaneService.getAirplaneById(1L)).thenReturn(Optional.of(new AirplaneEntity( "Model-101", 100, 10)));
        mockMvc.perform(get("/airplanes/1"))
                .andDo(print())
                .andExpect(status().isUnauthorized());

        System.out.println("------------------- AirplaneControllerTest findNoLoginRejected ------------------------------");
    }

}
