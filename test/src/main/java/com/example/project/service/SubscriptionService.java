package com.example.final_project.service;

import com.example.final_project.repository.SubscriptionRepository;
import com.example.final_project.view.SubscriptionViewModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionService(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    public List<SubscriptionViewModel> getAllCards() {
        return subscriptionRepository.findAll()
                .stream().map(subscription -> {
                    SubscriptionViewModel subscriptionViewModel = new SubscriptionViewModel();

                    subscriptionViewModel.setId(subscription.getId());
                    subscriptionViewModel.setType(subscription.getType().name().
                            replaceAll("_", " "));
                    subscriptionViewModel.setPrice(subscription.getPrice());
                    subscriptionViewModel.setPeriod(subscription.getPeriod().
                            replaceAll("_", " "));
                    subscriptionViewModel.setImage(subscription.getImage());

                    return subscriptionViewModel;
                }).collect(Collectors.toList());
    }
}
