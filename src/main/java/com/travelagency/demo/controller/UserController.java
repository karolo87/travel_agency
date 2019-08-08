package com.travelagency.demo.controller;
import com.travelagency.demo.security.service.UserService;
import com.travelagency.demo.security.validator.UserValidator;
import com.travelagency.demo.security.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserValidator userValidator;


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

    @GetMapping("/admin/all-users")
    public String getAllUsers(Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());
        return "user/all-users";
    }

}
