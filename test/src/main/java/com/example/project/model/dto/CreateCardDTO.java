package com.example.final_project.model.dto;

import javax.validation.constraints.NotNull;

public class CreateCardDTO {

    @NotNull
    private String trainer = "";

    @NotNull
    private String plan = "";

    @NotNull
    private String subscription = "";

    @NotNull
    private String club = "";

    public CreateCardDTO() {
    }

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getSubscription() {
        return subscription;
    }

    public void setSubscription(String subscription) {
        this.subscription = subscription;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }
}
