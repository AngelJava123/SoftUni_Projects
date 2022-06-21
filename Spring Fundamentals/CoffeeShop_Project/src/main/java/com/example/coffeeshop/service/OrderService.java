package com.example.coffeeshop.service;

import com.example.coffeeshop.model.Category;
import com.example.coffeeshop.model.Order;
import com.example.coffeeshop.model.User;
import com.example.coffeeshop.model.dto.OrderDTO;
import com.example.coffeeshop.model.enums.CategoryNameEnum;
import com.example.coffeeshop.repository.CategoryRepository;
import com.example.coffeeshop.repository.OrderRepository;
import com.example.coffeeshop.repository.UserRepository;
import com.example.coffeeshop.session.LoggedUser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final CategoryRepository categoryRepository;
    private final LoggedUser loggedUser;
    private final UserRepository userRepository;

    public OrderService(OrderRepository orderRepository,
                        CategoryRepository categoryRepository,
                        LoggedUser loggedUser,
                        UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
        this.loggedUser = loggedUser;
        this.userRepository = userRepository;
    }

    public boolean addOrder(OrderDTO orderDTO) {

        CategoryNameEnum type = switch (orderDTO.getCategory()) {
            case 0 -> CategoryNameEnum.COFFEE;
            case 1 -> CategoryNameEnum.CAKE;
            case 2 -> CategoryNameEnum.DRINK;
            case 3 -> CategoryNameEnum.OTHER;
            default -> CategoryNameEnum.OTHER;
        };

        Category category = this.categoryRepository.findByName(type);
        Optional<User> employee = this.userRepository.findById(this.loggedUser.getId());

        Order order = new Order();

        order.setName(orderDTO.getName());
        order.setPrice(orderDTO.getPrice());
        order.setOrderTime(orderDTO.getOrderTime());
        order.setCategory(category);
        order.setDescription(orderDTO.getDescription());
        order.setEmployee(employee.get());

        this.orderRepository.save(order);

        return true;
    }

    public List<Order> findAllOrdersOrderedByPriceDesc() {

        return this.orderRepository.findAllByOrderByPriceDesc();
    }

    public void readyOrder(Long id) {

        orderRepository.deleteById(id);
    }
}
