package com.example.gira_project.repository;

import com.example.gira_project.model.Classification;
import com.example.gira_project.model.enums.ClassificationNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassificationRepository extends JpaRepository<Classification, Long> {
    Classification findByName(ClassificationNameEnum type);
}
