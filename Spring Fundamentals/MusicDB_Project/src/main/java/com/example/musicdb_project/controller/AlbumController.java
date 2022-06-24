package com.example.musicdb_project.controller;

import com.example.musicdb_project.model.dto.AlbumDTO;
import com.example.musicdb_project.service.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class AlbumController {

    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @ModelAttribute("albumDTO")
    public AlbumDTO albumDTO() {
        return new AlbumDTO();
    }

    @GetMapping("/album/add")
    public String albumAdd() {
        return "add-album";
    }

    @PostMapping("/album/add")
    public String addAlbum(@Valid AlbumDTO albumDTO,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() || !this.albumService.addAlbum(albumDTO)) {
            redirectAttributes.addFlashAttribute("albumDTO", albumDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.albumDTO", bindingResult);

            return "redirect:/album/add";
        }

        return "redirect:/home";
    }

    @GetMapping("/album/delete/{id}")
    public String buyById(@PathVariable Long id) {
        albumService.deleteById(id);
        return "redirect:/home";
    }
}
