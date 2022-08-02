package com.example.final_project.repository;

import com.example.final_project.model.entity.TrainingPlan;
import com.example.final_project.model.enums.Title;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingPlansRepository extends JpaRepository<TrainingPlan, Long> {

    TrainingPlan findByTitle(Title title);
}
