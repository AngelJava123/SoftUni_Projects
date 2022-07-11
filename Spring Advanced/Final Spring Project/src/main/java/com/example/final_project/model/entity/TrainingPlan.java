package com.example.final_project.model.entity;

import com.example.final_project.model.enums.Goal;
import com.example.final_project.model.enums.Level;
import com.example.final_project.model.enums.MuscleGroup;

import javax.persistence.*;

@Entity
@Table(name = "training_plans")
public class TrainingPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String description;

    private Level level;

    private Goal goal;

    private MuscleGroup muscleGroup;
}
