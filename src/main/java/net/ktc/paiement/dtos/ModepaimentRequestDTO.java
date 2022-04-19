package net.ktc.paiement.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModepaimentRequestDTO {


    private String id;
    private String intitule;
    private String description;

}
