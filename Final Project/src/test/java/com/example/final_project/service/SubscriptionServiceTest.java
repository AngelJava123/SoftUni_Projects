package com.example.final_project.service;

import com.example.final_project.model.entity.Subscription;
import com.example.final_project.model.enums.Type;
import com.example.final_project.repository.SubscriptionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class SubscriptionServiceTest {

    @Mock
    private SubscriptionRepository mockSubscriptionRepo;

    private SubscriptionService toTest;

    @BeforeEach
    void setUp() {
        toTest = new SubscriptionService(
                mockSubscriptionRepo
        );
    }

    @Test
    void TestGetAllCards() {
        Subscription subscription1 = new Subscription();
        Subscription subscription2 = new Subscription();
        Subscription subscription3 = new Subscription();

        subscription1.setType(Type.VIP);
        subscription1.setImage("static/images/subs1.jpg");
        subscription1.setPeriod("ONE MONTH");
        subscription1.setPrice(BigDecimal.valueOf(40));

        subscription2.setType(Type.ONE_YEAR);
        subscription2.setImage("static/images/subs2.jpg");
        subscription2.setPeriod("ONE YEAR");
        subscription2.setPrice(BigDecimal.valueOf(500));

        subscription3.setType(Type.TREE_MONTHS);
        subscription3.setImage("static/images/subs3.jpg");
        subscription3.setPeriod("TREE MONTHS");
        subscription3.setPrice(BigDecimal.valueOf(140));

        List<Subscription> subscriptions = new ArrayList<>(Arrays.asList(subscription1, subscription2, subscription3));

        Mockito.when(mockSubscriptionRepo.findAll()).thenReturn(subscriptions);

        toTest.getAllCards();

        Assertions.assertEquals(subscription1.getType().name(), mockSubscriptionRepo.findAll().get(0).getType().name());
        Assertions.assertEquals(subscription2.getType().name(), mockSubscriptionRepo.findAll().get(1).getType().name());
        Assertions.assertEquals(subscription3.getType().name(), mockSubscriptionRepo.findAll().get(2).getType().name());

        Assertions.assertEquals(3, mockSubscriptionRepo.findAll().size());
    }
}
