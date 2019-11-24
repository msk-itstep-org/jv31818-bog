package org.itstep.msk.app.controller;

import org.itstep.msk.app.entity.User;
import org.itstep.msk.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class CommonController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/{id}")
    public String showUser(@PathVariable Long id, Model model) {
        Optional<User> a = userRepository.findById(id);
        model.addAttribute("user", a.orElse(new User()));
        return "user";
    }
}
