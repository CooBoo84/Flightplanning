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
import se.iths.flightplanning.controller.WorkerController;
import se.iths.flightplanning.dto.WorkerDto;
import se.iths.flightplanning.entity.WorkerEntity;
import se.iths.flightplanning.service.WorkerService;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WorkerController.class)
@AutoConfigureMockMvc
@EnableWebMvc
public class WorkerTests extends WebSecurityConfigurerAdapter {

    @MockBean
    WorkerService workerService;

    @MockBean
    WorkerEntity workerDto;

    @MockBean
    WorkerController workerController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testWorkerControllerInitializedCorrectly() {
        assertThat(workerController).isNotNull();
    }

    @Test
    public void testReturnAllWorkersSuccess() throws Exception {

        when(workerService.findAllWorkers()).thenReturn(List.of(new WorkerEntity(10, 100)));

        var result = mockMvc.perform(MockMvcRequestBuilders.get("/workers")
                        .with(SecurityMockMvcRequestPostProcessors.user("kungen").roles("ADMIN"))
                        .with(csrf())
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();
        assertThat(result.getResponse().getStatus()).isEqualTo(200);
    }

    @Test
    public void testReturnOneWorkerSuccess() throws Exception {

        when(workerService.getWorkerById(1L)).thenReturn(Optional.of(new WorkerEntity(20, 200)));

        var result = mockMvc.perform(MockMvcRequestBuilders.get("/workers/{id}", "1")
                        .with(SecurityMockMvcRequestPostProcessors.user("kungen").roles("ADMIN"))
                        .with(csrf())
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();
        assertThat(result.getResponse().getStatus()).isEqualTo(200);
    }

    @Test
    public void testCreateWorkerSuccess() throws Exception {
        WorkerEntity worker = new WorkerEntity(5, 8);
        Gson gson = new Gson();
        when(workerService.createWorker(worker)).thenReturn(worker);

        var result = mockMvc.perform(MockMvcRequestBuilders.post("/workers")
                        .with(SecurityMockMvcRequestPostProcessors.user("kungen").roles("ADMIN"))
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gson.toJson(worker))
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();
        assertThat(result.getResponse().getStatus()).isEqualTo(200);
    }

    @Test
    public void testDeleteRouteSuccess() throws Exception {
        new WorkerDto(1 , 1);
        workerService.deleteWorkerById(1L);
        Mockito.verify(workerService).deleteWorkerById(1L);
    }

}
