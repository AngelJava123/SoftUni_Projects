package com.example.final_project.web;

import com.example.final_project.service.TrainerService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
    public String trainer(Model model,
                          @PageableDefault(
                                  sort = "trainerName",
                                  direction = Sort.Direction.ASC,
                                  page = 0,
                                  size = 5) Pageable pageable) {
        model.addAttribute("allTrainers", trainerService.getAllTrainers(pageable));
        return "/trainers";
    }
}
