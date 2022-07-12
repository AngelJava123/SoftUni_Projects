package com.example.final_project.model.entity;

import com.example.final_project.model.enums.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "memberships")
public class Membership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Type type;

    private BigDecimal price;

    private LocalDate from;

    private LocalDate to;

}
