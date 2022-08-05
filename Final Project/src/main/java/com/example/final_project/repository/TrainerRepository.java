package com.example.final_project.repository;

import com.example.final_project.model.entity.Trainer;
import com.example.final_project.model.enums.TrainerName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long> {

    Trainer findByTrainerName(TrainerName trainerName);
}
