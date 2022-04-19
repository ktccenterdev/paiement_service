package net.ktc.paiement.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoyenPaiementRequestDTO {

    private String id;
    private String intitule;
    private String description;
    private String configuration;
    private String customerId;
}
