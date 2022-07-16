package ru.kata.spring.boot_security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService service;

    public AdminController(UserService service) {
        this.service = service;
    }

    @RequestMapping
    public String showAllUsers(Model model) {

        List<User> userList = service.getAll();
        model.addAttribute("userList", userList);

        return "admin";
    }

    @RequestMapping("/newUser")
    public String addUser(Model model, @ModelAttribute ("user") User user) {
        List<Role> roles = service.listRoles();
        model.addAttribute("roles", roles);
        return "newUser";
    }

    @RequestMapping("/saveUser")
    public String saveUser(@ModelAttribute ("user") User user) {
        service.save(user);
        return "redirect:/admin";
    }
    @GetMapping("/updateUser")
    public String updateUserInfo(@RequestParam("userId") Long id, Model model) {
        User user = service.getById(id);
        List<Role> roles = service.listRoles();
        model.addAttribute("user", user);
        model.addAttribute("roles", roles);
        return "newUser";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam("userId") Long id) {
        service.remove(id);
        return "redirect:/admin";
    }
}