package com.example.shoppinglist_project.controller;

import com.example.shoppinglist_project.model.enums.CategoryNameEnum;
import com.example.shoppinglist_project.service.ProductService;
import com.example.shoppinglist_project.session.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final LoggedUser loggedUser;
    private final ProductService productService;

    public HomeController(LoggedUser loggedUser, ProductService productService) {
        this.loggedUser = loggedUser;
        this.productService = productService;
    }

    @GetMapping("/home")
    public String home(Model model) {

        model.addAttribute("totalSum", productService.getTotalSum());
        model.addAttribute("drinks", productService.
                findAllProductsByCategoryName(CategoryNameEnum.DRINK));
        model.addAttribute("food", productService.
                findAllProductsByCategoryName(CategoryNameEnum.FOOD));
        model.addAttribute("household", productService.
                findAllProductsByCategoryName(CategoryNameEnum.HOUSEHOLD));
        model.addAttribute("other", productService.
                findAllProductsByCategoryName(CategoryNameEnum.OTHER));

        return "home";
    }

    @GetMapping("/logout")
    public String logout() {
        loggedUser.logOut();
        return "index";
    }

}
