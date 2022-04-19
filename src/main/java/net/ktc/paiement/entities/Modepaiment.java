package net.ktc.paiement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Modepaiment {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id")
    private String id;
    private String intitule;
    private String description;
    private String customerId;

    //@OneToMany(mappedBy="modepaiment")
   // private Set<MoyenPaiement> moyenPaiements;
}
