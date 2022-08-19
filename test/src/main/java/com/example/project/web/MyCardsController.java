package com.example.final_project.web;

import com.example.final_project.model.user.HerculesUserDetails;
import com.example.final_project.service.CardService;
import com.example.final_project.view.CardViewModel;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MyCardsController {

    private final CardService cardService;

    public MyCardsController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/my-cards")
    public String profile(Model model,
                          @AuthenticationPrincipal HerculesUserDetails userDetails) {

        model.addAttribute("cardViewModel", new CardViewModel());
        model.addAttribute("cards", cardService.getAllCards(userDetails));

        return "my-cards";
    }

    @GetMapping("/card/remove/{id}")
    public String removeById(@PathVariable Long id) {
        cardService.deleteById(id);
        return "redirect:/my-cards";
    }

    @GetMapping("/adminCard/remove/{id}")
    public String removeCardById(@PathVariable Long id) {
        cardService.deleteById(id);
        return "redirect:/admins";
    }
}
