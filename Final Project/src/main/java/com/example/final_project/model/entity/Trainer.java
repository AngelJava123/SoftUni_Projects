package com.example.final_project.model.entity;

import com.example.final_project.model.enums.Specialization;
import com.example.final_project.model.enums.TrainerName;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "trainers")
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    @Column(name = "trainer_name")
    private TrainerName trainerName;

    @NotNull
    @Min(21)
    private int age;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private Specialization specialization;

    private String image;

    public Trainer() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public TrainerName getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(TrainerName trainerName) {
        this.trainerName = trainerName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
