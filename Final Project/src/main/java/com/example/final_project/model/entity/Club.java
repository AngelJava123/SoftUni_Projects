package com.example.final_project.model.entity;

import com.example.final_project.model.enums.AdditionalAmenities;
import com.example.final_project.model.enums.Clubs;
import org.springframework.format.annotation.DateTimeFormat;

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
    @Enumerated(value = EnumType.STRING)
    private Clubs title;

    @NotNull
    private String location;

    @NotNull
    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalTime openingHour;

    @NotNull
    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalTime closingHour;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    @Column(name = "additional_amenities")
    private AdditionalAmenities additionalAmenities;

    private String image;

    public Club() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalTime getOpeningHour() {
        return openingHour;
    }

    public void setOpeningHour(LocalTime openingHour) {
        this.openingHour = openingHour;
    }

    public LocalTime getClosingHour() {
        return closingHour;
    }

    public void setClosingHour(LocalTime closingHour) {
        this.closingHour = closingHour;
    }

    public AdditionalAmenities getAmenities() {
        return additionalAmenities;
    }

    public void setAmenities(AdditionalAmenities additionalAmenities) {
        this.additionalAmenities = additionalAmenities;
    }

    public Clubs getTitle() {
        return title;
    }

    public void setTitle(Clubs title) {
        this.title = title;
    }

    public AdditionalAmenities getAdditionalAmenities() {
        return additionalAmenities;
    }

    public void setAdditionalAmenities(AdditionalAmenities additionalAmenities) {
        this.additionalAmenities = additionalAmenities;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
