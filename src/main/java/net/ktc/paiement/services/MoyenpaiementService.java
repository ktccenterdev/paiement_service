package net.ktc.paiement.services;

import net.ktc.paiement.dtos.MoyenPaiementRequestDTO;
import net.ktc.paiement.dtos.MoyenPaiementResponseDTO;

import java.util.List;

public interface MoyenpaiementService {

    MoyenPaiementResponseDTO getOne(String id);
    List<MoyenPaiementResponseDTO> getAll();
    MoyenPaiementResponseDTO save(MoyenPaiementRequestDTO moyenPaiementRequestDTO);
    MoyenPaiementResponseDTO update(MoyenPaiementRequestDTO moyenPaiementRequestDTO);

    void delete(String id);
}
