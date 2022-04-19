package net.ktc.paiement.mapper;

import net.ktc.paiement.dtos.ModepaimentRequestDTO;
import net.ktc.paiement.dtos.ModepaimentResponseDTO;
import net.ktc.paiement.entities.Modepaiment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModePaiementMapper {
    ModepaimentResponseDTO modepaimenToModepaiementResponseDTO(Modepaiment modepaiment);
    Modepaiment modepaaimentRequestDTOModepaiement(ModepaimentRequestDTO modepaimentRequestDTO);
    ModepaimentResponseDTO fromModepaiment(Modepaiment modepaiment);

}
