package org.itstep.msk.app.controller;

import org.itstep.msk.app.entity.Role;
import org.itstep.msk.app.entity.User;
import org.itstep.msk.app.repository.RoleRepository;
import org.itstep.msk.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/users")
    public String getPersonal(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "admin/users";
    }

    @DeleteMapping("/user/{id}")
    @ResponseBody
    public String delete(@PathVariable Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            userRepository.deleteById(id);
            userRepository.flush();
            roleRepository.flush();
            return "OK";
        }
        throw new RuntimeException("Not Found");
    }

    @GetMapping("/user_add")
    public String addUser(Model model) {
        User user = new User();
        Set<Role> roles = new HashSet<>();
        Role role = roleRepository.findById(2L).orElse(new Role());
        roles.add(role);
        user.setRoles(roles);
        model.addAttribute("user", user);
        return "admin/user_add";
    }

    @PostMapping("/user_add")
    public String saveUser(@ModelAttribute User user) {
        if (user.getUsername() == null) {
            return "redirect:/admin/users";
        }
        Set<Role> roles = new HashSet<>();
        Role role = roleRepository.findById(2L).orElse(new Role());
        roles.add(role);
        user.setRoles(roles);
        userRepository.save(user);
        userRepository.flush();
        return "redirect:/user/" + user.getId();
    }
}
