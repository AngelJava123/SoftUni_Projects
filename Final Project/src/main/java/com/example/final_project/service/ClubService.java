package com.example.final_project.service;

import com.example.final_project.repository.ClubRepository;
import com.example.final_project.view.ClubViewModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClubService {

    private final ClubRepository clubRepository;

    public ClubService(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    public Page<ClubViewModel> getAllClubs(Pageable pageable) {
        return clubRepository.findAll(pageable)
                .map(club -> {
                    ClubViewModel clubViewModel = new ClubViewModel();
                    clubViewModel.setId(club.getId());
                    clubViewModel.setTitle(club.getTitle().name().
                            replaceAll("_", " "));
                    clubViewModel.setLocation(club.getLocation());
                    clubViewModel.setOpeningHour(club.getOpeningHour());
                    clubViewModel.setClosingHour(club.getClosingHour());
                    clubViewModel.setAdditionalAmenities(club.getAdditionalAmenities().name().
                            replaceAll("_", " "));
                    clubViewModel.setImage(club.getImage());

                    return clubViewModel;
                });
    }
}
