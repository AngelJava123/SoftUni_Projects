package com.example.final_project.web;

import com.example.final_project.service.ClubService;
import com.example.final_project.service.TrainerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TrainerController {

    private final TrainerService trainerService;

    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @GetMapping("/trainers")
    public String trainer(Model model) {
        model.addAttribute("allTrainers", trainerService.getAllTrainers());
        return "/trainers";
    }
}
