package com.example.final_project.repository;

import com.example.final_project.model.entity.Subscription;
import com.example.final_project.model.enums.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    Subscription findByType(Type type);
}
