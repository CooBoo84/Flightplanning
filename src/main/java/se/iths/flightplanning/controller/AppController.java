package se.iths.flightplanning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import se.iths.flightplanning.entity.User;
import se.iths.flightplanning.service.UserService;

@Controller
public class AppController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method= RequestMethod.GET)
    public String showRegistrationPage(Model model){
        model.addAttribute("user", new User());
        return "registration";
    }

    @RequestMapping(value = "/register", method= RequestMethod.POST)
    public String processRegistrationPage(@ModelAttribute("user") User user, BindingResult result, Model model){
        model.addAttribute("user", user);
        if(result.hasErrors()){
            return "registration";
        }else
        {
            userService.createUser(user);
            model.addAttribute("message", "User Account Successfully Created");
        }
        return "application";
    }

    @RequestMapping("/")
    public String index()
    {
        return "index";
    }

    @RequestMapping("/login")
    public String login()
    {
        return "login";
    }

    @RequestMapping("/secure")
    public String secure()
    {
        return "secure";
    }


}
