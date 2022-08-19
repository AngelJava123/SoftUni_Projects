package com.example.final_project.web;

import com.example.final_project.model.user.HerculesUserDetails;
import com.example.final_project.service.CardService;
import com.example.final_project.view.ProfileViewModel;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    private final CardService cardService;

    public UserController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login-error")
    public String onFailedLogin(
            @ModelAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY) String userName,
            RedirectAttributes redirectAttributes) {

        redirectAttributes.addFlashAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY, userName);
        redirectAttributes.addFlashAttribute("bad_credentials", true);

        return "redirect:/login";
    }

    @GetMapping("/profile")
    public String profile(Model model,
                          @AuthenticationPrincipal HerculesUserDetails userDetails) {

        model.addAttribute("profileViewModel", new ProfileViewModel());
        model.addAttribute("profileDetails", cardService.getUserDetails(userDetails));

        return "profile";
    }
}
