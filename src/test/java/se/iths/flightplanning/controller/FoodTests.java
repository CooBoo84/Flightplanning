package se.iths.flightplanning.controller;

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
import se.iths.flightplanning.controller.FoodController;
import se.iths.flightplanning.entity.FoodEntity;
import se.iths.flightplanning.service.FoodService;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FoodController.class)
@AutoConfigureMockMvc
@EnableWebMvc
public class FoodTests extends WebSecurityConfigurerAdapter {

    @MockBean
    FoodService foodServiceDto;

    @MockBean
    FoodEntity foodDto;

    @MockBean
    FoodController foodController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testFoodControllerInitializedCorrectly() {
        assertThat(foodController).isNotNull();
    }

    @Test
    public void testReturnAllFoodSuccess() throws Exception {

        when(foodServiceDto.findAllFood()).thenReturn(List.of(new FoodEntity("Kebab")));

        var result = mockMvc.perform(MockMvcRequestBuilders.get("/food")
                        .with(SecurityMockMvcRequestPostProcessors.user("kungen").roles("ADMIN"))
                        .with(csrf())
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();
        assertThat(result.getResponse().getStatus()).isEqualTo(200);
    }

    @Test
    public void testReturnOneFoodSuccess() throws Exception {

        when(foodServiceDto.getFoodById(1L)).thenReturn(Optional.of(new FoodEntity( "Pizza")));

        var result = mockMvc.perform(MockMvcRequestBuilders.get("/food/{id}", "1")
                        .with(SecurityMockMvcRequestPostProcessors.user("kungen").roles("ADMIN"))
                        .with(csrf())
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();
        assertThat(result.getResponse().getStatus()).isEqualTo(200);
    }

    @Test
    public void testCreateFoodSuccess() throws Exception {
        FoodEntity food = new FoodEntity("Korvstroganoff");
        Gson gson = new Gson();
        when(foodServiceDto.createFood(food)).thenReturn(food);

        var result = mockMvc.perform(MockMvcRequestBuilders.post("/food")
                        .with(SecurityMockMvcRequestPostProcessors.user("kungen").roles("ADMIN"))
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gson.toJson(food))
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();
        assertThat(result.getResponse().getStatus()).isEqualTo(200);
    }

    @Test
    public void testDeleteFoodSuccess() throws Exception {
        new FoodEntity("Ostron");
        foodServiceDto.deleteFoodById(1L);
        Mockito.verify(foodServiceDto).deleteFoodById(1L);
    }

}
