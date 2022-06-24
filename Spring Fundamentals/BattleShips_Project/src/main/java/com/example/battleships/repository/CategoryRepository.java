package com.example.battleships.repository;

import com.example.battleships.model.Category;
import com.example.battleships.model.enums.ShipType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByName(ShipType type);
}
