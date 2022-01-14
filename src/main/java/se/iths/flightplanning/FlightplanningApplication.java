package se.iths.flightplanning;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import se.iths.flightplanning.entity.RoleEntity;
import se.iths.flightplanning.repository.RoleRepository;

@SpringBootApplication
public class FlightplanningApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlightplanningApplication.class, args);
    }

    // Generate data at startup
    @Bean
    public CommandLineRunner setUpRole(RoleRepository roleRepository) {
        return (args) -> {
            roleRepository.save(new RoleEntity("ROLE_ADMIN"));
            roleRepository.save(new RoleEntity("ROLE_USER"));
        };
    }

}
