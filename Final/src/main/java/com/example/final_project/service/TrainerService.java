package com.example.final_project.service;

import com.example.final_project.repository.TrainerRepository;
import com.example.final_project.view.TrainerViewModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainerService {

    private final TrainerRepository trainerRepository;

    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public List<TrainerViewModel> getAllTrainers() {
        return trainerRepository.findAll()
                .stream().map(trainer -> {
                    TrainerViewModel trainerViewModel = new TrainerViewModel();
                    trainerViewModel.setId(trainer.getId());
                    trainerViewModel.setAge(trainer.getAge());
                    trainerViewModel.setImage(trainer.getImage());
                    trainerViewModel.setTrainerName(trainer.getTrainerName().name().
                            replaceAll("_", " "));
                    trainerViewModel.setSpecialization(trainer.getSpecialization().name().
                            replaceAll("_", " "));
                    return trainerViewModel;
                }).collect(Collectors.toList());
    }
}
