package com.example.final_project.web;

import com.example.final_project.service.CardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    private final CardService cardService;

    public AdminController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/admins")
    public String profile(Model model) {

        model.addAttribute("allCards", cardService.getAllUsersCards());

        return "admins";
    }
}
