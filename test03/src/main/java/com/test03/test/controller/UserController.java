package com.test03.test.controller;

import com.test03.test.User;
import com.test03.test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // REST API to fetch all users
    @GetMapping("/api")
    @ResponseBody
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // View: List all users
    @GetMapping
    public String listUsers(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "user_list";
    }

    // View: Show the form to add a new user
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("user", new User());
        return "user_form";
    }

    // Process the form to add a new user
    @PostMapping
    public String createUser(@ModelAttribute User user) {
        userRepository.save(user);
        return "redirect:/users";
    }
    
    @GetMapping("/logins")
	public String showLoginpage() {
		return "login";
	}
}
