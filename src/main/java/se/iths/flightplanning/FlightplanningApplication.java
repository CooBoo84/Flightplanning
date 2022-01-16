package se.iths.flightplanning;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsTemplate;
import se.iths.flightplanning.entity.UserEntity;
import se.iths.flightplanning.entity.RoleEntity;
import se.iths.flightplanning.repository.RoleRepository;

@SpringBootApplication
public class FlightplanningApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(FlightplanningApplication.class, args);

        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);

        UserEntity customer = new UserEntity("Sven", "Gurka", "sven@gurka.se", "0315756856", "username", "password",true);

        jmsTemplate.convertAndSend("user", customer);
    }

    // Generate data at startup
    @Bean
    public CommandLineRunner setUpRole(RoleRepository roleRepository) {
        return (args) -> {
            roleRepository.save(new RoleEntity("ROLE_ADMIN"));
            roleRepository.save(new RoleEntity("ROLE_USER"));
            roleRepository.save(new RoleEntity("ROLE_VIP"));
        };
    }

}
