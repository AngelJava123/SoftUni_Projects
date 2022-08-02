package com.example.final_project.service;

import com.example.final_project.repository.TrainingPlansRepository;
import com.example.final_project.view.SubscriptionViewModel;
import com.example.final_project.view.TrainingPlansViewModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainingPlansService {

    private final TrainingPlansRepository trainingPlansRepository;

    public TrainingPlansService(TrainingPlansRepository trainingPlansRepository) {
        this.trainingPlansRepository = trainingPlansRepository;
    }

    public List<TrainingPlansViewModel> getAllTrainingPlans() {
        return trainingPlansRepository.findAll()
                .stream().map(trainingPlan -> {
                    TrainingPlansViewModel trainingPlansViewModel = new TrainingPlansViewModel();

                    trainingPlansViewModel.setId(trainingPlan.getId());
                    trainingPlansViewModel.setTitle(trainingPlan.getTitle().name().replaceAll("_", " "));
                    trainingPlansViewModel.setLevel(trainingPlan.getLevel().name().replaceAll("_", " "));
                    trainingPlansViewModel.setGoal(trainingPlan.getGoal().name().replaceAll("_", " "));
                    trainingPlansViewModel.setMuscleGroup(trainingPlan.getMuscleGroup().name().replaceAll("_", " "));

                    return trainingPlansViewModel;
                }).collect(Collectors.toList());
    }
}
