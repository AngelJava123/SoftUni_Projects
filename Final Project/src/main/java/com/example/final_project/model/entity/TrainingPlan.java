package com.example.final_project.model.entity;

import com.example.final_project.model.enums.Goal;
import com.example.final_project.model.enums.Level;
import com.example.final_project.model.enums.MuscleGroup;
import com.example.final_project.model.enums.Title;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "training_plans")
public class TrainingPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private Title title;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private Level level;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private Goal goal;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    @Column(name = "muscle_group")
    private MuscleGroup muscleGroup;

    public TrainingPlan() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    public MuscleGroup getMuscleGroup() {
        return muscleGroup;
    }

    public void setMuscleGroup(MuscleGroup muscleGroup) {
        this.muscleGroup = muscleGroup;
    }
}
