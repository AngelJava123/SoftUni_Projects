package com.example.final_project.web;

import com.example.final_project.service.ClubService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClubController {

    private final ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping("/clubs")
    public String club(Model model,
                       @PageableDefault(
                               sort = "title",
                               direction = Sort.Direction.ASC,
                               page = 0,
                               size = 5) Pageable pageable) {

        model.addAttribute("allClubs", clubService.getAllClubs(pageable));
        return "/clubs";
    }
}
