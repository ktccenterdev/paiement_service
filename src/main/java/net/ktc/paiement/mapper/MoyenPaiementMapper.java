package net.ktc.paiement.mapper;

import net.ktc.paiement.dtos.MoyenPaiementRequestDTO;
import net.ktc.paiement.dtos.MoyenPaiementResponseDTO;
import net.ktc.paiement.entities.MoyenPaiement;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MoyenPaiementMapper {
    MoyenPaiementResponseDTO moyenpaimentToMoyenPaimentResponseDTO(MoyenPaiement moyenPaiement);
    MoyenPaiement moyenPaimentRequestDTOMoyenpaiment(MoyenPaiementRequestDTO moyenPaiementRequestDTO);

}
