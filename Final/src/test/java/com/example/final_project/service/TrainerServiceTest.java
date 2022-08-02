package com.example.final_project.service;

import com.example.final_project.model.entity.Trainer;
import com.example.final_project.model.enums.Specialization;
import com.example.final_project.model.enums.TrainerName;
import com.example.final_project.repository.TrainerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class TrainerServiceTest {

    @Mock
    private TrainerRepository mockTrainerRepo;

    private TrainerService toTest;

    @BeforeEach
    void setUp() {
        toTest = new TrainerService(
                mockTrainerRepo
        );
    }

    @Test
    void testGetAllTrainers() {
        Trainer trainer1 = new Trainer();
        Trainer trainer2 = new Trainer();
        Trainer trainer3 = new Trainer();

        trainer1.setTrainerName(TrainerName.NICK_MITCHELL);
        trainer1.setAge(43);
        trainer1.setImage("static/images/trainer1.jpg");
        trainer1.setSpecialization(Specialization.UPPER_BODY);

        trainer2.setTrainerName(TrainerName.KAYLA_ITSINES);
        trainer2.setAge(30);
        trainer2.setImage("static/images/trainer2.jpg");
        trainer2.setSpecialization(Specialization.LOWER_BODY);

        trainer3.setTrainerName(TrainerName.DARA_MIKO);
        trainer3.setAge(29);
        trainer3.setImage("static/images/trainer3.jpg");
        trainer3.setSpecialization(Specialization.UPPER_BODY);

        List<Trainer> trainers = new ArrayList<>(Arrays.asList(trainer1, trainer2, trainer3));

        Mockito.when(mockTrainerRepo.findAll()).thenReturn(trainers);

        toTest.getAllTrainers();

        Assertions.assertEquals(trainer1.getTrainerName().name(), mockTrainerRepo.findAll().get(0).getTrainerName().name());
        Assertions.assertEquals(trainer2.getTrainerName().name(), mockTrainerRepo.findAll().get(1).getTrainerName().name());
        Assertions.assertEquals(trainer3.getTrainerName().name(), mockTrainerRepo.findAll().get(2).getTrainerName().name());

        Assertions.assertEquals(3, mockTrainerRepo.findAll().size());
    }
}
