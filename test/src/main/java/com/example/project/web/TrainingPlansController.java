package com.example.final_project.web;

import com.example.final_project.service.TrainingPlansService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TrainingPlansController {

    private final TrainingPlansService trainingPlansService;

    public TrainingPlansController(TrainingPlansService trainingPlansService) {
        this.trainingPlansService = trainingPlansService;
    }

    @GetMapping("/training-plans")
    public String trainingPlans(Model model) {
        model.addAttribute("allTrainingPlans", trainingPlansService.getAllTrainingPlans());
        return "/training-plans";
    }

}
