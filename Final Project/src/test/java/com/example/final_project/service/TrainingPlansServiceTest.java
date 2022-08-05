package com.example.final_project.service;

import com.example.final_project.model.entity.TrainingPlan;
import com.example.final_project.model.enums.Goal;
import com.example.final_project.model.enums.Level;
import com.example.final_project.model.enums.MuscleGroup;
import com.example.final_project.model.enums.Title;
import com.example.final_project.repository.TrainingPlansRepository;
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
public class TrainingPlansServiceTest {

    @Mock
    private TrainingPlansRepository mockTrainingPlansRepo;

    private TrainingPlansService toTest;

    @BeforeEach
    void setUp() {
        toTest = new TrainingPlansService(
                mockTrainingPlansRepo
        );
    }

    @Test
    void getAllTrainingPlansTest() {
        TrainingPlan trainingPlan1 = new TrainingPlan();
        TrainingPlan trainingPlan2 = new TrainingPlan();
        TrainingPlan trainingPlan3 = new TrainingPlan();

        trainingPlan1.setGoal(Goal.GAIN_MUSCLE_MASS);
        trainingPlan1.setLevel(Level.ADVANCED);
        trainingPlan1.setTitle(Title.TIMELY_TRAINING);
        trainingPlan1.setMuscleGroup(MuscleGroup.CHEST);

        trainingPlan2.setGoal(Goal.GET_SHREDDED);
        trainingPlan2.setLevel(Level.INTERMEDIATE);
        trainingPlan2.setTitle(Title.FOCUS_FITNESS);
        trainingPlan2.setMuscleGroup(MuscleGroup.ABS);

        trainingPlan3.setGoal(Goal.LOST_WEIGHT);
        trainingPlan3.setLevel(Level.BEGINNER);
        trainingPlan3.setTitle(Title.FLEX_ED);
        trainingPlan3.setMuscleGroup(MuscleGroup.ABS);

        List<TrainingPlan> trainingPlans = new ArrayList<>(Arrays.asList(trainingPlan1, trainingPlan2, trainingPlan3));

        Mockito.when(mockTrainingPlansRepo.findAll()).thenReturn(trainingPlans);

        toTest.getAllTrainingPlans();

        Assertions.assertEquals(trainingPlan1.getTitle().name(), mockTrainingPlansRepo.findAll().get(0).getTitle().name());
        Assertions.assertEquals(trainingPlan2.getTitle().name(), mockTrainingPlansRepo.findAll().get(1).getTitle().name());
        Assertions.assertEquals(trainingPlan3.getTitle().name(), mockTrainingPlansRepo.findAll().get(2).getTitle().name());

        Assertions.assertEquals(3, mockTrainingPlansRepo.findAll().size());
     }
}
