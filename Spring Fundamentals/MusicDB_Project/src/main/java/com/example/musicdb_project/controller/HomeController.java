package com.example.musicdb_project.controller;

import com.example.musicdb_project.service.AlbumService;
import com.example.musicdb_project.session.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final LoggedUser loggedUser;
    private final AlbumService albumService;

    public HomeController(LoggedUser loggedUser,
                          AlbumService albumService) {
        this.loggedUser = loggedUser;
        this.albumService = albumService;
    }

    @GetMapping("/home")
    public String home(Model model) {

        model.addAttribute("totalCopies", albumService.getTotalCopies());
        model.addAttribute("albums", albumService.findAll());
        return "home";
    }

    @GetMapping("/logout")
    public String logout() {
        loggedUser.logOut();
        return "index";
    }
}
