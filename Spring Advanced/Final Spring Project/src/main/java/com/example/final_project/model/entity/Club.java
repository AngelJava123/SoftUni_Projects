package com.example.final_project.model.entity;

import com.example.final_project.model.enums.Amenities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;

@Entity
@Table(name = "clubs")
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String title;

    @NotNull
    private String location;

    @NotNull
    private LocalTime openingHour;

    @NotNull
    private LocalTime closingHour;

    @NotNull
    private Amenities amenities;
}
