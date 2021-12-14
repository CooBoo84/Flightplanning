package se.iths.flightplanning.view;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
<<<<<<< HEAD
        registry.addViewController("/application").setViewName("application");
        registry.addViewController("/admin").setViewName("admin");
        registry.addViewController("/login").setViewName("login");

    }

=======
        registry.addViewController("/users").setViewName("users");
        registry.addViewController("/routes").setViewName("routes");
        registry.addViewController("/admin").setViewName("admin");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/register").setViewName("register");

    }
>>>>>>> d705337efabc22873f15df12bfde23dfd2219f3f
}
