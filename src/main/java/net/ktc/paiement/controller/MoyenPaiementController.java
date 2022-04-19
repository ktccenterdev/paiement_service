package net.ktc.paiement.controller;

import net.ktc.paiement.dtos.MoyenPaiementRequestDTO;
import net.ktc.paiement.dtos.MoyenPaiementResponseDTO;
import net.ktc.paiement.services.MoyenpaiementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class MoyenPaiementController {

    private MoyenpaiementService moyenpaiementService;

    public MoyenPaiementController(MoyenpaiementService moyenpaiementService) {
        this.moyenpaiementService = moyenpaiementService;
    }


    @GetMapping(path = "/moyenpaiment")
    public List<MoyenPaiementResponseDTO> getAll(){
        return moyenpaiementService.getAll();
    }

    @PostMapping(path = "/moyenpaiment")
    public MoyenPaiementResponseDTO save(@RequestBody MoyenPaiementRequestDTO moyenPaiementRequestDTO){
        return  moyenpaiementService.save(moyenPaiementRequestDTO);

    }

    @GetMapping(path = "/moyenpaiment/{id}")
    public  MoyenPaiementResponseDTO getMoyenpaiement(@PathVariable String id){
        return moyenpaiementService.getOne(id);

    }

    @DeleteMapping(path="/moyenpaiment/{id}")
    public void delete(@PathVariable(name = "id") String id) {
        moyenpaiementService.delete(id);

    }

    @PutMapping(path="/moyenpaiment")
    public MoyenPaiementResponseDTO update(@RequestBody MoyenPaiementRequestDTO moyenPaiementRequestDTO) {
        return moyenpaiementService.update(moyenPaiementRequestDTO);
    }

}
