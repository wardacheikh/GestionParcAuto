package com.GestionAuto.Trip.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Vehicule {
    @Id
    private String matricule ;
    private String mark ;
    private String model ;
    @Enumerated(EnumType.STRING)
    private VehiculeType vehiculeType ;
    private boolean disponibilite ;
    @Enumerated(EnumType.STRING)
    private PermisType permisType;
    private String equipement_speciaux ;
}
