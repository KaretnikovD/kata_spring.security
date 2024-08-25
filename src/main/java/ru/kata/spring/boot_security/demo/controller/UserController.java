package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;


@Controller
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin")
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "show-all-users";
    }

    @GetMapping("/user")
    public String userPage1(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        model.addAttribute(user);
        return "user";
    }

    @GetMapping("admin/{id}/edit_user")
    public String showUserById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getByID(id));
        return "edit-user";
    }

    @PatchMapping("admin/{id}")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/admin";
    }

    @DeleteMapping("admin/{id}")
    public String deleteUser(@ModelAttribute("user") User user) {
        userService.delete(user);
        return "redirect:/admin";
    }

    @GetMapping("admin/new_user")
    public String newUser(@ModelAttribute("user") User user) {
        return "new-user";
    }

    @PostMapping("/admin/save_new_user")
    public String addUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/admin";
    }

}
