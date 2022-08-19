package com.example.final_project.web;

import com.example.final_project.service.SubscriptionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @GetMapping("/subscriptions")
    public String subscription(Model model) {
        model.addAttribute("allCards", subscriptionService.getAllCards());
        return "/subscriptions";
    }
}
