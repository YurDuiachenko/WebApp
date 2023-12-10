package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.models.Model;
import com.example.springdatabasicdemo.models.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface OfferRepository extends JpaRepository<Offer, UUID> {
    Optional<Offer> findById(UUID id);

    Offer findFirstByModel(Model model);
}
