package com.travelagency.demo.controller;

import com.travelagency.demo.security.service.SecurityService;
import com.travelagency.demo.security.service.SecurityServiceImpl;
import com.travelagency.demo.security.service.UserService;
import com.travelagency.demo.security.validator.UserValidator;
import com.travelagency.demo.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

//    @Autowired
    private UserService userService;
//    @Autowired
    private SecurityService securityService;
//    @Autowired
    private UserValidator userValidator;

    @Autowired
    public UserController(UserService userService, SecurityService securityService, UserValidator userValidator) {
        this.userService = userService;
        this.securityService = securityService;
        this.userValidator = userValidator;
    }

    @GetMapping("/register")
    public String registerUser(Model model) {
        model.addAttribute("userForm", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUserPost(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "register";
        }
        userService.save(userForm);
        securityService.autoLogin(userForm.getUsername(), userForm.getConfirmPassword());
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Nieprawidłowa nazwa użytkownika lub hasło.");
        }
        if (logout != null) {
            model.addAttribute("message", "Wylogowano pomyślnie.");
        }
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(@RequestParam("username") String login,
                            @RequestParam("password") String password) {
        SecurityServiceImpl securityService = new SecurityServiceImpl();
        securityService.autoLogin(login, password);

        return "/";
    }

    @GetMapping("/welcome")
    public String welcome(Model model) {
        return "welcome";
    }
}
