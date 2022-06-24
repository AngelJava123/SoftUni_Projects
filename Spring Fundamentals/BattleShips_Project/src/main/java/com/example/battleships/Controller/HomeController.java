package com.example.battleships.Controller;

import com.example.battleships.model.dto.StartBattleDTO;
import com.example.battleships.service.ShipService;
import com.example.battleships.session.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HomeController {

    private final ShipService shipService;
    private final LoggedUser loggedUser;

    public HomeController(ShipService shipService, LoggedUser loggedUser) {
        this.shipService = shipService;
        this.loggedUser = loggedUser;
    }

    @ModelAttribute("startBattleDTO")
    public StartBattleDTO startBattleDTO() {
        return new StartBattleDTO();
    }

    @GetMapping("/home")
    public String loggedInIndex(Model model) {
        model.addAttribute("shipsOwnedByCurrentUser", shipService.getAllShipsOwnedByCurrentUser());
        model.addAttribute("shipsOwnedByOtherUsers", shipService.getAllShipsFromOtherUsers());
        model.addAttribute("listedShips", shipService.getAllShips());
        return "home";
    }

    @GetMapping("/logout")
    public String logout() {
        loggedUser.logout();
        return "redirect:/";
    }
}
