package org.itstep.msk.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {



    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/access-denied")
    public String getAccessDenied() {
        return "denied";
    }


//    public String getUsername(Principal principal) {
//        if (principal == null) {
//            return "no principal";
//        }
//
//        User user = userRepository.findByUsername(principal.getName()).orElse(null);
//        if (user != null) {
//            return user.getRoles().stream()
//                    .map(Role::getRole) // Из коллекции объектов Role получаем коллекцию строк - названий ролей
//                    .collect(Collectors.joining(", ")); // Объединяем коллекцию названий ролей в одну строчку - перечисление через запятую
//        }
//        return "no user";
//
////        model.addAttribute(user);
////        System.out.println(user.toString());
////        if (user == null) {
////            return "redirect:/";
////        }
////
////        if (user.getRoles().toString().contains("ROLE_ADMIN")){
////            return "redirect:/admin/personal";
////        }
////
////        return "personal.html";
//    }
}
