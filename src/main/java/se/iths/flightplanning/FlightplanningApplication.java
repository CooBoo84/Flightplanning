package se.iths.flightplanning;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsTemplate;
import se.iths.flightplanning.entity.*;
import se.iths.flightplanning.repository.*;

@SpringBootApplication
public class FlightplanningApplication  {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(FlightplanningApplication.class, args);

        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);

        CustomerEntity customer = new CustomerEntity("Sven", "Gurka", "sven@gurka.se", "0315756856", "username", "password");

        jmsTemplate.convertAndSend("user", customer);
    }

    @Bean
    public CommandLineRunner setUpRole(RoleRepository roleRepository) {
        return (args) -> {
            roleRepository.save(new RoleEntity("ROLE_ADMIN"));
            roleRepository.save(new RoleEntity("ROLE_USER"));
        };
    }
}
