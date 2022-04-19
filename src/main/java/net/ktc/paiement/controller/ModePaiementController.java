package net.ktc.paiement.controller;


import net.ktc.paiement.dtos.ModepaimentRequestDTO;
import net.ktc.paiement.dtos.ModepaimentResponseDTO;
import net.ktc.paiement.services.ModepaimentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class ModePaiementController {
    private ModepaimentService modepaimentService;

    public ModePaiementController(ModepaimentService modepaimentService) {
        this.modepaimentService = modepaimentService;
    }


    @GetMapping(path = "/modepaiment")
    public List<ModepaimentResponseDTO> getAll(){
        return modepaimentService.getAll();
    }

    @PostMapping(path = "/modepaiment")
    public ModepaimentResponseDTO save(@RequestBody ModepaimentRequestDTO modepaimentRequestDTO){
        return  modepaimentService.save(modepaimentRequestDTO);

    }

    @GetMapping(path = "/modepaiment/{id}")
    public  ModepaimentResponseDTO getModepaiement(@PathVariable String id){
        return modepaimentService.getOne(id);

    }

    @DeleteMapping(path="/modepaiment/{id}")
    public void delete(@PathVariable(name = "id") String id) {
        modepaimentService.delete(id);

    }

    @PutMapping(path="/modepaiment")
    public ModepaimentResponseDTO update(@RequestBody ModepaimentRequestDTO modepaimentRequestDTO) {
        return modepaimentService.update(modepaimentRequestDTO);
    }



















































}
