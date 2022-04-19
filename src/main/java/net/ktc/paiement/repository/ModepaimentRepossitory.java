package net.ktc.paiement.repository;

import net.ktc.paiement.entities.Modepaiment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ModepaimentRepossitory extends JpaRepository<Modepaiment,String> {
    List<Modepaiment> findByCustomerId(String customerId);
}
