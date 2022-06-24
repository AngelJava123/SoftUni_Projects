package com.example.musicdb_project.repository;

import com.example.musicdb_project.model.Artist;
import com.example.musicdb_project.model.enums.ArtistNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {

    Artist findByName(ArtistNameEnum artistName);
}
