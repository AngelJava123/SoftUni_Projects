package com.example.coffeeshop.controller;

import com.example.coffeeshop.model.dto.OrderDTO;
import com.example.coffeeshop.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @ModelAttribute("orderDTO")
    public OrderDTO addOrderDTO() {
        return new OrderDTO();
    }

    @GetMapping("/order/add")
    public String addOrder() {
        return "order-add";
    }

    @PostMapping("order/add")
    public String addOrder(@Valid OrderDTO orderDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() || !this.orderService.addOrder(orderDTO)) {
            redirectAttributes.addFlashAttribute("orderDTO", orderDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.orderDTO", bindingResult);

            return "redirect:/order/add";
        }

        return "redirect:/home";
    }

    @GetMapping("/orders/ready/{id}")
    public String ready(@PathVariable Long id) {
        orderService.readyOrder(id);

        return "redirect:/home";
    }
}
