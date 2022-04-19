package net.ktc.paiement.services;

import net.ktc.paiement.dtos.ModepaimentRequestDTO;
import net.ktc.paiement.dtos.ModepaimentResponseDTO;
import net.ktc.paiement.entities.Modepaiment;
import net.ktc.paiement.exception.ResourceNotFoundException;
import net.ktc.paiement.mapper.ModePaiementMapper;
import net.ktc.paiement.openfeign.CustomerRestClient;
import net.ktc.paiement.repository.ModepaimentRepossitory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class ModepaimentServiceImpl implements ModepaimentService {


    private ModepaimentRepossitory modepaimentRepossitory;
    private ModePaiementMapper modePaiementMapper;
    private CustomerRestClient customerRestClient;

    public ModepaimentServiceImpl(ModepaimentRepossitory modepaimentRepossitory, ModePaiementMapper modePaiementMapper, CustomerRestClient customerRestClient) {
        this.modepaimentRepossitory = modepaimentRepossitory;
        this.modePaiementMapper = modePaiementMapper;
        this.customerRestClient = customerRestClient;
    }


    @Override
    public ModepaimentResponseDTO getOne(String id) {
        Modepaiment modepaiment = modepaimentRepossitory.findById(id).get();
        try{
           return modePaiementMapper.modepaimenToModepaiementResponseDTO(modepaiment);
        } catch (Exception exception) {
        throw new ResourceNotFoundException("cannot retrieve Modepaiement ");
    }

}

    @Override
    public List<ModepaimentResponseDTO> getAll() {
        List<Modepaiment> modepaiments=modepaimentRepossitory.findAll();
        try{
            List<ModepaimentResponseDTO> modepaimentResponseDTOS=
                    modepaiments.stream()
                            .map(mod->modePaiementMapper.modepaimenToModepaiementResponseDTO(mod))
                            .collect(Collectors.toList());
            return modepaimentResponseDTOS;
        } catch (Exception exception) {
            throw new ResourceNotFoundException("cannot retrieve All Modepaiement ");
        }

    }

    @Override
    public ModepaimentResponseDTO save(ModepaimentRequestDTO modepaimentRequestDTO) {
        Modepaiment modepaiment = modePaiementMapper.modepaaimentRequestDTOModepaiement(modepaimentRequestDTO);
        try{
            Modepaiment saveModePaiment=modepaimentRepossitory.save(modepaiment);

            ModepaimentResponseDTO modepaimentResponseDTO = modePaiementMapper.modepaimenToModepaiementResponseDTO(saveModePaiment);
            return modepaimentResponseDTO;
        } catch (Exception exception) {
            throw new ResourceNotFoundException("cannot save this Modepaiement,verify your inputs ");
        }
    }

    @Override
    public ModepaimentResponseDTO update(ModepaimentRequestDTO modepaimentRequestDTO) {
        Modepaiment modepaiment = modePaiementMapper.modepaaimentRequestDTOModepaiement(modepaimentRequestDTO);

        try{
            Modepaiment updateModepaiement = modepaimentRepossitory.save(modepaiment);
            return modePaiementMapper.modepaimenToModepaiementResponseDTO(updateModepaiement);
        } catch (Exception exception) {
            throw new ResourceNotFoundException("cannot save this Modepaiement,verify your inputs ");
        }

    }

    @Override
    public List<ModepaimentResponseDTO> ModePaiementByCustomerId(String customerId) {
        List<Modepaiment> modepaiments=modepaimentRepossitory.findByCustomerId(customerId);

        try{
            return modepaiments
                    .stream()
                    .map(mod1 -> modePaiementMapper.fromModepaiment(mod1))
                    .collect(Collectors.toList());
        } catch (Exception exception) {
            throw new ResourceNotFoundException("cannot find this Modepaiement by eachcustomer ,verify your inputs ");
        }
    }

    @Override
    public void delete(String id) {

        try{
            modepaimentRepossitory.deleteById(id);
        } catch (Exception exception) {
            throw new ResourceNotFoundException("cannot delete this Modepaiement,verify!!!!");
        }
    }
}
