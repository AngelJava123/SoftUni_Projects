package com.example.gira_project.controller;

import com.example.gira_project.service.TaskService;
import com.example.gira_project.session.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final LoggedUser loggedUser;
    private final TaskService taskService;

    public HomeController(LoggedUser loggedUser,
                          TaskService taskService) {
        this.loggedUser = loggedUser;
        this.taskService = taskService;
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("allTasks", taskService.getAllTasks());
        return "home";
    }

    @GetMapping("/logout")
    public String logout() {
        loggedUser.logout();
        return "index";
    }
}
