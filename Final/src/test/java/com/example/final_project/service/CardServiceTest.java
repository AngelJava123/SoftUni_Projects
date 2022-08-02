package com.example.final_project.service;

import com.example.final_project.model.entity.*;
import com.example.final_project.model.enums.*;
import com.example.final_project.model.user.HerculesUserDetails;
import com.example.final_project.repository.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CardServiceTest {

    @Mock
    private TrainerRepository trainerRepository;

    @Mock
    private TrainingPlansRepository trainingPlansRepository;

    @Mock
    private SubscriptionRepository subscriptionRepository;

    @Mock
    private ClubRepository clubRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private CardRepository cardRepository;

    @Mock
    private ModelMapper modelMapper;

    private CardService toTest;

    private HerculesUserDetails userDetails;

    @BeforeEach
    void setUp() {
        toTest = new CardService(
                trainerRepository,
                trainingPlansRepository,
                subscriptionRepository,
                clubRepository,
                userRepository,
                cardRepository,
                modelMapper
        );
    }

    @Test
    void getAllCardsTest() {
        Club club1 = new Club();

        club1.setTitle(Clubs.LAS_TORTUGA);
        club1.setLocation("New York");
        club1.setImage("static/images/club1.jpg");
        club1.setAdditionalAmenities(AdditionalAmenities.SOLARIUM);
        club1.setOpeningHour(LocalTime.of(7, 0, 0));
        club1.setClosingHour(LocalTime.of(20, 0, 0));

        User testUser = new User();
        testUser.setEmail("angel@example.com");
        testUser.setPassword("121212");
        testUser.setUsername("angelVtashev");
        testUser.setFullName("AngelTashev");
        testUser.setAge(21);
        testUser.setWallet(BigDecimal.valueOf(300));

        Subscription subscription1 = new Subscription();

        subscription1.setType(Type.VIP);
        subscription1.setImage("static/images/subs1.jpg");
        subscription1.setPeriod("ONE MONTH");
        subscription1.setPrice(BigDecimal.valueOf(40));

        Trainer trainer1 = new Trainer();

        trainer1.setTrainerName(TrainerName.NICK_MITCHELL);
        trainer1.setAge(43);
        trainer1.setImage("static/images/trainer1.jpg");
        trainer1.setSpecialization(Specialization.UPPER_BODY);

        TrainingPlan trainingPlan1 = new TrainingPlan();

        trainingPlan1.setGoal(Goal.GAIN_MUSCLE_MASS);
        trainingPlan1.setLevel(Level.ADVANCED);
        trainingPlan1.setTitle(Title.TIMELY_TRAINING);
        trainingPlan1.setMuscleGroup(MuscleGroup.CHEST);

        Card card = new Card();

        card.setTrainer(trainer1);
        card.setClub(club1);
        card.setPlan(trainingPlan1);
        card.setSubscription(subscription1);
        card.setUser(testUser);

        List<Card> cards = new ArrayList<>(List.of(card));

        Mockito.when(cardRepository.findAll()).thenReturn(cards);

        toTest.getAllUsersCards();

        Assertions.assertEquals(card.getClub().getTitle().name(), cardRepository.findAll().get(0).getClub().getTitle().name());
        Assertions.assertEquals(card.getPlan().getTitle().name(), cardRepository.findAll().get(0).getPlan().getTitle().name());
        Assertions.assertEquals(card.getSubscription().getType().name(), cardRepository.findAll().get(0).getSubscription().getType().name());

        Assertions.assertEquals(1, cardRepository.findAll().size());
    }
}
