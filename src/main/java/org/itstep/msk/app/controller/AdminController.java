package org.itstep.msk.app.controller;

import org.itstep.msk.app.entity.Role;
import org.itstep.msk.app.entity.User;
import org.itstep.msk.app.repository.RoleRepository;
import org.itstep.msk.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
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
//            user.getRoles().forEach(
//                    role -> user.removeFromRoles(role)
//            );
            userRepository.deleteById(id);
            userRepository.flush();
            roleRepository.flush();
            return "OK";
        }
        throw new RuntimeException("Not Found");
    }

//    @GetMapping("/user_add")
//    public String addUser(Model model, @ModelAttribute User user, @ModelAttribute Set<Role> roles) {
//        Set<Role> allRoles = (Set)roleRepository.findAll();
//        model.addAttribute("roles", allRoles);
//        user.setRoles(roles);
//        userRepository.saveAndFlush(user);
//        return "admin/user_add";
//    }

//    @PostMapping("/user_add")
//    public String addUser(@ModelAttribute User user, @ModelAttribute Set<Role> roles) {
//        user.setRoles(roles);
//        userRepository.saveAndFlush(user);
//        return "admin/users";
//    }
}
