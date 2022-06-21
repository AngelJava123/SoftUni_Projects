package com.example.coffeeshop.controller;

import com.example.coffeeshop.model.Order;
import com.example.coffeeshop.service.AuthService;
import com.example.coffeeshop.service.OrderService;
import com.example.coffeeshop.session.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class HomeController {

    private final LoggedUser loggedUser;
    private final OrderService orderService;
    private final AuthService authService;

    public HomeController(LoggedUser loggedUser,
                          OrderService orderService,
                          AuthService authService) {
        this.loggedUser = loggedUser;
        this.orderService = orderService;
        this.authService = authService;
    }

    @ModelAttribute("Order")
    public Order order() {
        return new Order();
    }

    @GetMapping("/home")
    public String loggedInIndex(Model model) {

        if (loggedUser.getId() == 0) {
            return "index";
        }

        List<Order> orders = this.orderService.findAllOrdersOrderedByPriceDesc();

        model.addAttribute("orders", orders);
        model.addAttribute("totalTime", orders.
                stream().
                map(order -> order.getCategory().getNeededTime())
                .reduce(Integer::sum)
                .orElse(0));

        model.addAttribute("users", this.authService.findAllUserAndCountOfOrdersOrderByCountDesc());
        return "home";
    }
}
