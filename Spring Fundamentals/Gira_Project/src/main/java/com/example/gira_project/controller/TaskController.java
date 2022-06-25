package com.example.gira_project.controller;

import com.example.gira_project.model.dto.TaskDTO;
import com.example.gira_project.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @ModelAttribute("taskDTO")
    public TaskDTO taskDTO() {
        return new TaskDTO();
    }

    @GetMapping("/task/add")
    public String addTask() {
        return "add-task";
    }

    @PostMapping("/task/add")
    public String register(@Valid TaskDTO taskDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() || !this.taskService.addTask(taskDTO)) {
            redirectAttributes.addFlashAttribute("taskDTO", taskDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.taskDTO", bindingResult);

            return "redirect:/task/add";
        }

        return "redirect:/home";
    }

    @GetMapping("/task/change/{id}")
    public String changeById(@PathVariable Long id) {
        taskService.changeById(id);
        return "redirect:/home";
    }
}
