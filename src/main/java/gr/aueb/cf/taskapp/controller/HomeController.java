package gr.aueb.cf.taskapp.controller;

import gr.aueb.cf.taskapp.model.User;
import gr.aueb.cf.taskapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;


    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }


    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.saveUser(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }


    @GetMapping("/logout")
    public String logout(Authentication authentication) {
        if (authentication != null) {
            SecurityContextHolder.clearContext();
        }
        return "redirect:/login";
    }

    @GetMapping("/")
    public String home(Authentication authentication) {
        if (authentication != null &&  authentication.isAuthenticated()) {
            return "redirect:/tasks";

        }
        return "redirect:/login";
    }
}
