package com.example.final_project.service;

import com.example.final_project.model.entity.Club;
import com.example.final_project.model.enums.AdditionalAmenities;
import com.example.final_project.model.enums.Clubs;
import com.example.final_project.repository.ClubRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.time.LocalTime;
import java.util.Arrays;

@ExtendWith(MockitoExtension.class)
public class ClubServiceTest {

    @Mock
    private ClubRepository mockClubRepo;

    private ClubService toTest;

    @BeforeEach
    void setUp() {
        toTest = new ClubService(
                mockClubRepo
        );
    }

    @Test
    void TestGetAllClubs() {
        Club club1 = new Club();
        Club club2 = new Club();
        Club club3 = new Club();

        club1.setTitle(Clubs.LAS_TORTUGA);
        club1.setLocation("New York");
        club1.setImage("static/images/club1.jpg");
        club1.setAdditionalAmenities(AdditionalAmenities.SOLARIUM);
        club1.setOpeningHour(LocalTime.of(7, 0, 0));
        club1.setClosingHour(LocalTime.of(20, 0, 0));

        club2.setTitle(Clubs.ALICANTE_DIAMOND);
        club2.setLocation("London");
        club2.setImage("static/images/club2.jpg");
        club2.setAdditionalAmenities(AdditionalAmenities.SWIMMING_POOL);
        club2.setOpeningHour(LocalTime.of(7, 0, 0));
        club2.setClosingHour(LocalTime.of(20, 0, 0));

        club3.setTitle(Clubs.AMSTERDAM);
        club3.setLocation("Paris");
        club3.setImage("static/images/club3.jpg");
        club3.setAdditionalAmenities(AdditionalAmenities.SPA);
        club3.setOpeningHour(LocalTime.of(7, 0, 0));
        club3.setClosingHour(LocalTime.of(20, 0, 0));

        Mockito.when(mockClubRepo.findAll(Pageable.unpaged())).thenReturn(new PageImpl<>(Arrays.asList(club1, club2, club3)));

        toTest.getAllClubs(Pageable.unpaged());

       // Assertions.assertEquals(club1.getTitle().name(), mockClubRepo.findAll().get(0).getTitle().name());
       // Assertions.assertEquals(club2.getTitle().name(), mockClubRepo.findAll().get(1).getTitle().name());
       // Assertions.assertEquals(club3.getTitle().name(), mockClubRepo.findAll().get(2).getTitle().name());
//
       // Assertions.assertEquals(3, mockClubRepo.findAll().size());
    }
}
