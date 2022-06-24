package com.example.musicdb_project.repository;

import com.example.musicdb_project.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {

    @Query("SELECT SUM(a.copies) FROM Album a")
    Integer findTotalCopiesSum();
}
