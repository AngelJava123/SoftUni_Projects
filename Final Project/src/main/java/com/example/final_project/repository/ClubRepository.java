package com.example.final_project.repository;

import com.example.final_project.model.entity.Club;
import com.example.final_project.model.entity.User;
import com.example.final_project.model.enums.Clubs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {

    Club findByTitle(Clubs clubs);

}
