package se.iths.flightplanning;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import se.iths.flightplanning.entity.UserEntity;
import se.iths.flightplanning.service.UserService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static se.iths.flightplanning.LogInUtils.getTokenForLogin;

public class AdminProtectedRestControllerTest extends AbstractControllerTest {

   @Autowired
   UserService userService;

   @Test
   public void getAdminProtectedGreetingForUser() throws Exception {
      UserEntity user = new UserEntity("Sven", "Gurka", "sven@gurka.se", "0315756856", "user", "password",false);
      userService.createUserWithoutRole(user);
      final String token = getTokenForLogin("user", "password", getMockMvc());

      getMockMvc().perform(get("/auth/hiddenmessage")
         .contentType(MediaType.APPLICATION_JSON)
         .header("Authorization", "Bearer " + token))
         .andExpect(status().isForbidden());
   }

   @Test
   public void getAdminProtectedGreetingForAdmin() throws Exception {
      UserEntity user = new UserEntity("Sven", "Gurka", "sven@gurka.se", "0315756856", "admin", "admin",true);
      userService.createUserWithoutRole(user);
      final String token = getTokenForLogin("admin", "admin", getMockMvc());

      getMockMvc().perform(get("/auth/hiddenmessage")
                      .contentType(MediaType.APPLICATION_JSON)
                      .header("Authorization", "Bearer " + token))
              .andExpect(status().isOk())
              .andExpect(content().json(
                      "{\n" +
                              "  \"message\" : \"this is a hidden message!\"\n" +
                              "}"
              ));
   }

   @Test
   public void getAdminProtectedGreetingForAnonymous() throws Exception {
      getMockMvc().perform(get("/auth/hiddenmessage")
         .contentType(MediaType.APPLICATION_JSON))
         .andExpect(status().isUnauthorized());
   }

}
