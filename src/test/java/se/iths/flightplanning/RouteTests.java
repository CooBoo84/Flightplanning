package se.iths.flightplanning;

import com.google.gson.Gson;
//import org.junit.Test;
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
import se.iths.flightplanning.controller.RouteController;
import se.iths.flightplanning.entity.RouteEntity;
import se.iths.flightplanning.service.RouteService;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RouteController.class)
@AutoConfigureMockMvc
@EnableWebMvc
public class RouteTests extends WebSecurityConfigurerAdapter {

    @MockBean
    RouteService routeServiceDto;

    @MockBean
    RouteEntity routeDto;

    @MockBean
    RouteController routeController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testRouteControllerInitializedCorrectly() {
        assertThat(routeController).isNotNull();
    }

    @Test
    public void testReturnAllRoutesSuccess() throws Exception {

        when(routeServiceDto.findAllRoutes()).thenReturn(List.of(new RouteEntity("Gbg-Sth")));

        var result = mockMvc.perform(MockMvcRequestBuilders.get("/routes")
                        .with(SecurityMockMvcRequestPostProcessors.user("kungen").roles("ADMIN"))
                        .with(csrf())
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();
        assertThat(result.getResponse().getStatus()).isEqualTo(200);
    }

    @Test
    public void testReturnOneRouteSuccess() throws Exception {

        when(routeServiceDto.getRouteById(1L)).thenReturn(Optional.of(new RouteEntity( "LA-Gbg")));

        var result = mockMvc.perform(MockMvcRequestBuilders.get("/routes/{id}", "1")
                        .with(SecurityMockMvcRequestPostProcessors.user("kungen").roles("ADMIN"))
                        .with(csrf())
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();
        assertThat(result.getResponse().getStatus()).isEqualTo(200);
    }

    @Test
    public void testCreateRouteSuccess() throws Exception {
        RouteEntity route = new RouteEntity("Lnd-Gbg");
        Gson gson = new Gson();
        when(routeServiceDto.createRoute(route)).thenReturn(route);

        var result = mockMvc.perform(MockMvcRequestBuilders.post("/routes")
                        .with(SecurityMockMvcRequestPostProcessors.user("kungen").roles("ADMIN"))
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gson.toJson(route))
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();
        assertThat(result.getResponse().getStatus()).isEqualTo(200);
    }

    @Test
    public void testDeleteRouteSuccess() throws Exception {
        new RouteEntity("Malmö-Umeå");
        routeServiceDto.deleteRouteById(1L);
        Mockito.verify(routeServiceDto).deleteRouteById(1L);
    }

}
