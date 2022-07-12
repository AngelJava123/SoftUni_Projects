package com.example.final_project.model.entity;

import com.example.final_project.model.enums.Specialization;

import javax.persistence.*;

@Entity
@Table(name = "trainers")
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;

    private String lastName;

    private int age;

    private Specialization specialization;
}
