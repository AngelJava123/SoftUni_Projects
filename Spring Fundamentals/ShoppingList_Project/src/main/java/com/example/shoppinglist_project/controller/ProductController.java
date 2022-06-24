package com.example.shoppinglist_project.controller;

import com.example.shoppinglist_project.model.dto.ProductDTO;
import com.example.shoppinglist_project.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @ModelAttribute("productDTO")
    public ProductDTO productDTO() {
        return new ProductDTO();
    }

    @GetMapping("/product/add")
    public String productAdd() {
        return "product-add";
    }

    @PostMapping("/product/add")
    public String addProduct(@Valid ProductDTO productDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() || !this.productService.addProduct(productDTO)) {
            redirectAttributes.addFlashAttribute("productDTO", productDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.productDTO", bindingResult);

            return "redirect:/product/add";
        }

        return "redirect:/home";
    }

    @GetMapping("/product/buy/{id}")
    public String buyById(@PathVariable Long id) {
        productService.buyById(id);
        return "redirect:/home";
    }

    @GetMapping("/product/buy/all")
    public String buyAll() {
        productService.buyAll();
        return "redirect:/home";
    }
}
