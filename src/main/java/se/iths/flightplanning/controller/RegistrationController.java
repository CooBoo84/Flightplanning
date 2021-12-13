//package se.iths.flightplanning.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
////import se.iths.flightplanning.dto.UserRegistrationDto;
//import se.iths.flightplanning.entity.User;
//import se.iths.flightplanning.service.UserService;
//
//@Controller
//@RequestMapping("/register")
//public class RegistrationController {
//
//	private UserService userService;
//
//	public RegistrationController(UserService userService) {
//		super();
//		this.userService = userService;
//	}
//
//	@ModelAttribute("user")
//	public User user() {
//		return new User();
//	}
//
//	@GetMapping
//	public String showRegistrationForm() {
//		return "register";
//	}
//
//	@PostMapping
//	public String registerUserAccount(@ModelAttribute("user")User user) {
//		userService.createUser(user);
//		return "redirect:/register?success";
//	}
//}
