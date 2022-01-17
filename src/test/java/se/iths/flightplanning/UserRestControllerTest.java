package se.iths.flightplanning;

//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import se.iths.flightplanning.entity.UserEntity;
import se.iths.flightplanning.service.UserService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static se.iths.flightplanning.LogInUtils.getTokenForLogin;

public class UserRestControllerTest extends AbstractControllerTest {

   @Autowired
   UserService userService;

   @Test
   public void getPersonForUser() throws Exception {
      UserEntity user = new UserEntity("Test2", "User2", "test@user.se", "0315756856", "user2", "password2",false);
      userService.createUserWithoutRole(user);
      final String token = getTokenForLogin("user2", "password2", getMockMvc());

      assertSuccessfulPersonRequest(token);
   }

   @Test
   public void getPersonForAdmin() throws Exception {
      UserEntity user = new UserEntity("Test2", "User2", "test@user.se", "0315756856", "admin2", "admin2",true);
      userService.createUserWithoutRole(user);
      final String token = getTokenForLogin("admin2", "admin2", getMockMvc());

      assertSuccessfulPersonRequest(token);
   }

   @Test
   public void getPersonForAnonymous() throws Exception {
      getMockMvc().perform(get("/users/1")
         .contentType(MediaType.APPLICATION_JSON))
         .andExpect(status().isUnauthorized());
   }

   private void assertSuccessfulPersonRequest(String token) throws Exception {
      getMockMvc().perform(get("/users/1")
         .contentType(MediaType.APPLICATION_JSON)
         .header("Authorization", "Bearer " + token))
         .andExpect(status().isOk())
         .andExpect(content().json(
            "{\n" +
               "  \"firstName\" : \"Test2\",\n" +
               "  \"lastName\" : \"User2\",\n" +
               "  \"email\" : \"test@user.se\",\n" +
               "  \"telephone\" : \"0315756856\"\n" +
               "}"
         ));
   }
}
