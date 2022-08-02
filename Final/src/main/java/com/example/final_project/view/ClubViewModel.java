package com.example.final_project.view;

import java.time.LocalTime;

public class ClubViewModel {

    private long id;
    private String title;
    private String location;
    private LocalTime openingHour;
    private LocalTime closingHour;
    private String additionalAmenities;
    private String image;

    public ClubViewModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getAdditionalAmenities() {
        return additionalAmenities;
    }

    public void setAdditionalAmenities(String additionalAmenities) {
        this.additionalAmenities = additionalAmenities;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
