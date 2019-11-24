package org.itstep.msk.app.controller;

import org.itstep.msk.app.entity.User;
import org.itstep.msk.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class SecurityController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String getLogin(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @GetMapping("/registration")
    public String getRegistration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String postRegistration() {
        return "redirect:/login";
    }

    @GetMapping("/username")
    public String username(Principal principal) {
        if (principal == null) {
            return "redirect:/";
        }

        User user = userRepository
                .findByUsername(principal.getName())
                .orElse(null);

        if (user != null) {
            if (user.getRoles().toString().contains("ROLE_ADMIN")) {
                return "redirect:/admin/users";
            }
            return "personal";
        }

        return "redirect:/";
    }
}
