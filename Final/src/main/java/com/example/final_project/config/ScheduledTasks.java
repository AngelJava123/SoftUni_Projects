package com.example.final_project.config;

import com.example.final_project.model.entity.Card;
import com.example.final_project.model.entity.User;
import com.example.final_project.repository.CardRepository;
import com.example.final_project.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScheduledTasks {

    private final UserRepository userRepository;
    private final CardRepository cardRepository;
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    public ScheduledTasks(UserRepository userRepository, CardRepository cardRepository) {
        this.userRepository = userRepository;
        this.cardRepository = cardRepository;
    }

    @Scheduled(cron = "0 */12 * * * *")
    public void getAllRegisteredUsers() {
        List<User> allRegisteredUsers = this.userRepository.findAll();

        if (allRegisteredUsers.size() == 0) {
            log.info("There are 0 registered users yet.");
        } else {
            log.info("Number of registered users: " + allRegisteredUsers.size());
        }
    }

    @Scheduled(cron = "0 */12 * * * *")
    public void getAllRegisteredCards() {
        List<Card> allRegisteredCards = this.cardRepository.findAll();

        if (allRegisteredCards.size() == 0) {
            log.info("There are 0 registered cards yet.");
        } else {
            log.info("Number of registered cards: " + allRegisteredCards.size());
        }
    }
}
