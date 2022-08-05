package com.example.final_project.service;

import com.example.final_project.repository.TrainerRepository;
import com.example.final_project.view.TrainerViewModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TrainerService {

    private final TrainerRepository trainerRepository;

    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public Page<TrainerViewModel> getAllTrainers(Pageable pageable) {
        return trainerRepository.findAll(pageable)
                .map(trainer -> {
                    TrainerViewModel trainerViewModel = new TrainerViewModel();
                    trainerViewModel.setId(trainer.getId());
                    trainerViewModel.setAge(trainer.getAge());
                    trainerViewModel.setImage(trainer.getImage());
                    trainerViewModel.setTrainerName(trainer.getTrainerName().name().
                            replaceAll("_", " "));
                    trainerViewModel.setSpecialization(trainer.getSpecialization().name().
                            replaceAll("_", " "));
                    return trainerViewModel;
                });
    }
}
