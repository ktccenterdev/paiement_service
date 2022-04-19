package net.ktc.paiement.services;

import net.ktc.paiement.dtos.MoyenPaiementRequestDTO;
import net.ktc.paiement.dtos.MoyenPaiementResponseDTO;
import net.ktc.paiement.entities.MoyenPaiement;
import net.ktc.paiement.exception.ResourceNotFoundException;
import net.ktc.paiement.mapper.MoyenPaiementMapper;
import net.ktc.paiement.repository.MoyenPaiementRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MoyenpaiementServiceImpl implements MoyenpaiementService {


    private MoyenPaiementRepository moyenPaiementRepository;
    private MoyenPaiementMapper moyenPaiementMapper;

    public MoyenpaiementServiceImpl(MoyenPaiementRepository moyenPaiementRepository, MoyenPaiementMapper moyenPaiementMapper) {
        this.moyenPaiementRepository = moyenPaiementRepository;
        this.moyenPaiementMapper = moyenPaiementMapper;
    }


    @Override
    public MoyenPaiementResponseDTO getOne(String id) {
        MoyenPaiement moyenPaiement = moyenPaiementRepository.findById(id).get();

        try{
            return moyenPaiementMapper.moyenpaimentToMoyenPaimentResponseDTO(moyenPaiement);
        } catch (Exception exception) {
            throw new ResourceNotFoundException("cannot retrieve this Moyenpaiement,verify!!!!");
        }
    }

    @Override
    public List<MoyenPaiementResponseDTO> getAll() {
        List<MoyenPaiement> moyenPaiements=moyenPaiementRepository.findAll();
        try{
            List<MoyenPaiementResponseDTO> moyenPaiementResponseDTOS=
                    moyenPaiements.stream()
                            .map(moy->moyenPaiementMapper.moyenpaimentToMoyenPaimentResponseDTO(moy))
                            .collect(Collectors.toList());
            return moyenPaiementResponseDTOS;
        } catch (Exception exception) {
            throw new ResourceNotFoundException("cannot retrieve all this Moyenpaiement!!!");
        }

    }

    @Override
    public MoyenPaiementResponseDTO save(MoyenPaiementRequestDTO moyenPaiementRequestDTO) {
        MoyenPaiement moyenPaiement = moyenPaiementMapper.moyenPaimentRequestDTOMoyenpaiment(moyenPaiementRequestDTO);
        try{
            MoyenPaiement saveMoyenPaiement=moyenPaiementRepository.save(moyenPaiement);

            MoyenPaiementResponseDTO moyenPaiementResponseDTO = moyenPaiementMapper.moyenpaimentToMoyenPaimentResponseDTO(saveMoyenPaiement);
            return moyenPaiementResponseDTO;
        } catch (Exception exception) {
            throw new ResourceNotFoundException("cannot save this Moyenpaiement,verify!!!!");
        }
    }

    @Override
    public MoyenPaiementResponseDTO update(MoyenPaiementRequestDTO moyenPaiementRequestDTO) {
        MoyenPaiement moyenPaiement = moyenPaiementMapper.moyenPaimentRequestDTOMoyenpaiment(moyenPaiementRequestDTO);
        try{

            MoyenPaiement updateMoyenPaiement=moyenPaiementRepository.save(moyenPaiement);
            return moyenPaiementMapper.moyenpaimentToMoyenPaimentResponseDTO(updateMoyenPaiement);
        } catch (Exception exception) {
            throw new ResourceNotFoundException("cannot update this Moyenpaiement,verify!!!!");
        }
    }



    @Override
    public void delete(String id) {

        try{
            moyenPaiementRepository.deleteById(id);
        } catch (Exception exception) {
            throw new ResourceNotFoundException("cannot delete this Moyenpaiement,verify!!!!");
        }
    }
}
