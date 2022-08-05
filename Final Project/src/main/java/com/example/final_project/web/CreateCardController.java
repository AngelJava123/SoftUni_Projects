package com.example.final_project.web;

import com.example.final_project.model.dto.CreateCardDTO;
import com.example.final_project.model.user.HerculesUserDetails;
import com.example.final_project.service.CardService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class CreateCardController {

    private final CardService cardService;

    public CreateCardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/create-card")
    public String createCard() {
        return "create-card";
    }

    @ModelAttribute("createCardDTO")
    public CreateCardDTO createCardDTO() {
        return new CreateCardDTO();
    }

    @PostMapping("/create-card")
    public String createCard(@Valid CreateCardDTO createCardDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes,
                           @AuthenticationPrincipal HerculesUserDetails userDetails) {

        if (bindingResult.hasErrors() || !this.cardService.create(createCardDTO, userDetails)) {
            redirectAttributes.addFlashAttribute("createCardDTO", createCardDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.createCardDTO",
                    bindingResult);
            redirectAttributes.addFlashAttribute("badCredentials", true);

            return "redirect:/create-card";
        }

        /*this.cardService.create(createCardDTO, userDetails);*/

        return "redirect:/";
    }
}
