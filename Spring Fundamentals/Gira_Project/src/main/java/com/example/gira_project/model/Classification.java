package com.example.gira_project.model;

import com.example.gira_project.model.enums.ClassificationNameEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "classifications")
public class Classification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(unique = true)
    private ClassificationNameEnum name;

    @Column(columnDefinition = "TEXT")
    private String description;

    public Classification() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ClassificationNameEnum getName() {
        return name;
    }

    public void setName(ClassificationNameEnum name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
