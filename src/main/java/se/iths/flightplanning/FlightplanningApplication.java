package se.iths.flightplanning;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import se.iths.flightplanning.entity.*;
import se.iths.flightplanning.repository.*;

@SpringBootApplication
public class FlightplanningApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FlightplanningApplication.class, args);
	}

	AirplaneRepository airplaneRepository;
	RouteRepository routeRepository;
	CustomerRepository customerRepository;
	WorkerRepository workerRepository;
	FoodRepository foodRepository;
	RoleRepository roleRepository;

	public FlightplanningApplication(AirplaneRepository airplaneRepository, RouteRepository routeRepository, CustomerRepository customerRepository, WorkerRepository workerRepository, FoodRepository foodRepository, RoleRepository roleRepository) {
		this.airplaneRepository = airplaneRepository;
		this.routeRepository = routeRepository;
		this.customerRepository = customerRepository;
		this.workerRepository = workerRepository;
		this.foodRepository = foodRepository;
		this.roleRepository = roleRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		CustomerEntity user = new CustomerEntity("Hans", "Sandblom", "sdgdfsg@dhdh.se", "089674545", "username", "password");
		RouteEntity rutt1 = new RouteEntity("Gbg-Sthlm");
		AirplaneEntity air1 = new AirplaneEntity("Model-101", 100, 10);
		WorkerEntity worker = new WorkerEntity(2,8);
		FoodEntity food= new FoodEntity("Ja");
		CancellationProtectionEntity cancel = new CancellationProtectionEntity("Ja");
//		RoleEntity role = new RoleEntity("ROLE_VIP");
//
//		user.getRoles().add(role);
		rutt1.setCancel(cancel);
		rutt1.setFood(food);
		air1.getStaff().add(worker);
		rutt1.getAirplaneNames().add(air1);
		user.getRouteNames().add(rutt1);

		customerRepository.save(user);
	}

	@Bean
	public CommandLineRunner setUpRole(RoleRepository roleRepository) {
		return (args) -> {
			roleRepository.save(new RoleEntity("ROLE_ADMIN"));
			roleRepository.save(new RoleEntity("ROLE_USER"));
			roleRepository.save(new RoleEntity("ROLE_VIP"));
		};
	}
}
