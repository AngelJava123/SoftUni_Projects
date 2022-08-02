package com.example.final_project.service;

import com.example.final_project.constants.Dates;
import com.example.final_project.model.dto.CreateCardDTO;
import com.example.final_project.model.entity.*;
import com.example.final_project.model.enums.Clubs;
import com.example.final_project.model.enums.Title;
import com.example.final_project.model.enums.TrainerName;
import com.example.final_project.model.enums.Type;
import com.example.final_project.model.user.HerculesUserDetails;
import com.example.final_project.repository.*;
import com.example.final_project.view.CardViewModel;
import com.example.final_project.view.ProfileViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CardService {

    private final TrainerRepository trainerRepository;
    private final TrainingPlansRepository trainingPlansRepository;
    private final SubscriptionRepository subscriptionRepository;
    private final ClubRepository clubRepository;
    private final UserRepository userRepository;
    private final CardRepository cardRepository;
    private final ModelMapper modelMapper;

    public CardService(TrainerRepository trainerRepository,
                       TrainingPlansRepository trainingPlansRepository,
                       SubscriptionRepository subscriptionRepository,
                       ClubRepository clubRepository,
                       UserRepository userRepository,
                       CardRepository cardRepository, ModelMapper modelMapper) {
        this.trainerRepository = trainerRepository;
        this.trainingPlansRepository = trainingPlansRepository;
        this.subscriptionRepository = subscriptionRepository;
        this.clubRepository = clubRepository;
        this.userRepository = userRepository;
        this.cardRepository = cardRepository;
        this.modelMapper = modelMapper;
    }

    public boolean create(CreateCardDTO createCardDTO, HerculesUserDetails userDetails) {

        TrainerName trainerName = switch (createCardDTO.getTrainer()) {
            case "NICK_MITCHELL" -> TrainerName.NICK_MITCHELL;
            case "MATT_ROBERTS" -> TrainerName.MATT_ROBERTS;
            case "LOUISE_PARKER" -> TrainerName.LOUISE_PARKER;
            case "SHAUN_STAFFORD" -> TrainerName.SHAUN_STAFFORD;
            case "SCOTT_LAIDLER" -> TrainerName.SCOTT_LAIDLER;
            case "EMMA_CHAN" -> TrainerName.EMMA_CHAN;
            case "NICOLE_STANFORD" -> TrainerName.NICOLE_STANFORD;
            case "SHANON_MICHAEL" -> TrainerName.SHANON_MICHAEL;
            case "JOHN_SIEMENS" -> TrainerName.JOHN_SIEMENS;
            case "SANDRA_SIMONS" -> TrainerName.SANDRA_SIMONS;
            case "JESSICA_PORTERS" -> TrainerName.JESSICA_PORTERS;
            case "MICHAEL_SMITH" -> TrainerName.MICHAEL_SMITH;
            case "SIMON_SAIGON" -> TrainerName.SIMON_SAIGON;
            case "DARA_MIKO" -> TrainerName.DARA_MIKO;
            case "GAMET_GARADJ" -> TrainerName.GAMET_GARADJ;
            case "JACKIE_WARNER" -> TrainerName.JACKIE_WARNER;
            case "ALEXIA_CLARK" -> TrainerName.ALEXIA_CLARK;
            case "JOE_DOWDELL" -> TrainerName.JOE_DOWDELL;
            case "KAYLA_ITSINES" -> TrainerName.KAYLA_ITSINES;
            case "CHRISTIAN_THIBAUDEAU" -> TrainerName.CHRISTIAN_THIBAUDEAU;
            default -> TrainerName.NICK_MITCHELL;
        };

        Trainer trainer = this.trainerRepository.findByTrainerName(trainerName);

        Title title = switch (createCardDTO.getPlan()) {
            case "FITNESS_MANIACS" -> Title.FITNESS_MANIACS;
            case "OPTIMIZED_TRAINING" -> Title.OPTIMIZED_TRAINING;
            case "INSTRUCTIVELY" -> Title.INSTRUCTIVELY;
            case "ACTIVATE_ACADEMY" -> Title.ACTIVATE_ACADEMY;
            case "INNER_GROWTH" -> Title.INNER_GROWTH;
            case "TIMELY_TRAINING" -> Title.TIMELY_TRAINING;
            case "GRADE_POTENTIAL" -> Title.GRADE_POTENTIAL;
            case "THE_WATCHERS" -> Title.THE_WATCHERS;
            case "COURSE_METHOD" -> Title.COURSE_METHOD;
            case "CORPORATE_BUILDERS" -> Title.CORPORATE_BUILDERS;
            case "COSMIC_BRAIN" -> Title.COSMIC_BRAIN;
            case "NANO_TRAINER" -> Title.NANO_TRAINER;
            case "FLEX_ED" -> Title.FLEX_ED;
            case "FOCUS_FITNESS" -> Title.FOCUS_FITNESS;
            case "LESSON_UP" -> Title.LESSON_UP;
            default -> Title.FITNESS_MANIACS;
        };

        TrainingPlan trainingPlan = this.trainingPlansRepository.findByTitle(title);

        Type type = switch (createCardDTO.getSubscription()) {
            case "VIP" -> Type.VIP;
            case "STANDARD" -> Type.STANDARD;
            case "UNLIMITED_CLASSES" -> Type.UNLIMITED_CLASSES;
            case "EQUIPMENT_ONLY" -> Type.EQUIPMENT_ONLY;
            case "ONE_MONTH" -> Type.ONE_MONTH;
            case "TREE_MONTHS" -> Type.TREE_MONTHS;
            case "SIX_MONTHS" -> Type.SIX_MONTHS;
            case "ONE_YEAR" -> Type.ONE_YEAR;
            default -> Type.VIP;
        };

        Subscription subscription = this.subscriptionRepository.findByType(type);

        switch (subscription.getPeriod()) {
            case "ONE_MONTH" -> subscription.setPeriod(Dates.ONE_MONTH);
            case "TREE_MONTHS" -> subscription.setPeriod(Dates.TREE_MONTHS);
            case "SIX_MONTHS" -> subscription.setPeriod(Dates.SIX_MONTHS);
            case "ONE_YEAR" -> subscription.setPeriod(Dates.ONE_YEAR);
        }

        this.subscriptionRepository.save(subscription);

        Clubs clubs = switch (createCardDTO.getClub()) {
            case "LAS_TORTUGA" -> Clubs.LAS_TORTUGA;
            case "LONDON_PEARL" -> Clubs.LONDON_PEARL;
            case "PARIS_DIAMOND" -> Clubs.PARIS_DIAMOND;
            case "CASE_DE_SANTORINI" -> Clubs.CASE_DE_SANTORINI;
            case "VIVA_DE_FLORANCE" -> Clubs.VIVA_DE_FLORANCE;
            case "MALAGA_PEARL" -> Clubs.MALAGA_PEARL;
            case "ALICANTE_DIAMOND" -> Clubs.ALICANTE_DIAMOND;
            case "MADRID_MILLENNIAL" -> Clubs.MADRID_MILLENNIAL;
            case "MILANO_MILLENNIAL" -> Clubs.MILANO_MILLENNIAL;
            case "CASE_VENEZIA" -> Clubs.CASE_VENEZIA;
            case "WEST_MALLING" -> Clubs.WEST_MALLING;
            case "ROYSTON_DIAMOND" -> Clubs.ROYSTON_DIAMOND;
            case "LONDON_MILLENNIAL" -> Clubs.LONDON_MILLENNIAL;
            case "COLOMBES" -> Clubs.COLOMBES;
            case "HOUILLES" -> Clubs.HOUILLES;
            case "AMIENS_MILLENNIAL" -> Clubs.AMIENS_MILLENNIAL;
            case "MANASTIRSKI_LIVADI" -> Clubs.MANASTIRSKI_LIVADI;
            case "MLADOST" -> Clubs.MLADOST;
            case "DELUXE" -> Clubs.DELUXE;
            case "RING_MALL" -> Clubs.RING_MALL;
            case "GRAFENWOHR" -> Clubs.GRAFENWOHR;
            case "RAMSTEIN" -> Clubs.RAMSTEIN;
            case "WIESBADEN" -> Clubs.WIESBADEN;
            case "BERLIN_PEARL" -> Clubs.BERLIN_PEARL;
            case "UTRECHT" -> Clubs.UTRECHT;
            case "OOSTZAAN" -> Clubs.OOSTZAAN;
            case "EINDHOVEN" -> Clubs.EINDHOVEN;
            case "AMSTERDAM" -> Clubs.AMSTERDAM;
            default -> Clubs.LAS_TORTUGA;
        };

        Club club = this.clubRepository.findByTitle(clubs);

        Optional<User> user = userRepository.findByEmail(userDetails.getUsername());

        if (subscription.getPrice().compareTo(user.get().getWallet()) > 0) {
            return false;
        } else {
            user.get().setWallet(user.get().getWallet().subtract(subscription.getPrice()));
            this.userRepository.save(user.get());
        }

        Card card = new Card();

        card.setTrainer(trainer);
        card.setClub(club);
        card.setPlan(trainingPlan);
        card.setSubscription(subscription);
        card.setUser(user.get());

        this.cardRepository.save(card);

        return true;
    }

    public List<CardViewModel> getAllCards(HerculesUserDetails userDetails) {

        Optional<User> user = userRepository.findByEmail(userDetails.getUsername());

        List<Card> cards = user.get().getCards();

        return getCardViewModels(cards);
    }

    private List<CardViewModel> getCardViewModels(List<Card> cards) {
        return cards
                .stream().map(card -> {
                    CardViewModel cardViewModel = new CardViewModel();
                    cardViewModel.setId(card.getId());
                    cardViewModel.setTrainerName(card.getTrainer().getTrainerName().name().replaceAll("_", " "));
                    cardViewModel.setAge(card.getTrainer().getAge());
                    cardViewModel.setSpecialization(card.getTrainer().getSpecialization().name().replaceAll("_", " "));

                    cardViewModel.setTitle(card.getPlan().getTitle().name().replaceAll("_", " "));
                    cardViewModel.setLevel(card.getPlan().getLevel().name());
                    cardViewModel.setGoal(card.getPlan().getGoal().name().replaceAll("_", " "));
                    cardViewModel.setMuscleGroup(card.getPlan().getMuscleGroup().name().replaceAll("_", " "));

                    cardViewModel.setType(card.getSubscription().getType().name().replaceAll("_", " "));
                    cardViewModel.setPrice(card.getSubscription().getPrice());
                    cardViewModel.setPeriod(card.getSubscription().getPeriod());
                    cardViewModel.setImage(card.getSubscription().getImage());

                    cardViewModel.setTitleClub(card.getClub().getTitle().name().replaceAll("_", " "));
                    cardViewModel.setLocation(card.getClub().getLocation());
                    cardViewModel.setOpeningHour(card.getClub().getOpeningHour());
                    cardViewModel.setClosingHour(card.getClub().getClosingHour());
                    cardViewModel.setAdditionalAmenities(card.getClub().getAdditionalAmenities().name().replaceAll("_", " "));

                    cardViewModel.setUsername(card.getUser().getUsername());
                    cardViewModel.setFullName(card.getUser().getFullName());
                    cardViewModel.setAgeUser(card.getUser().getAge());
                    cardViewModel.setEmail(card.getUser().getEmail());

                    return cardViewModel;
                }).collect(Collectors.toList());
    }

    public ProfileViewModel getUserDetails(HerculesUserDetails userDetails) {

        Optional<User> user = userRepository.findByEmail(userDetails.getUsername());

        return modelMapper.map(user, ProfileViewModel.class);
    }

    public void deleteById(Long id) {
        cardRepository.deleteById(id);
    }

    public List<CardViewModel> getAllUsersCards() {

        List<Card> cards = cardRepository.findAll();

        return getCardViewModels(cards);
    }
}
