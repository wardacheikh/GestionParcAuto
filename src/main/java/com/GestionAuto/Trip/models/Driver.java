package com.GestionAuto.Trip.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Setter
public class Driver {
    @Id
    private Long id ;
    private String matricule ;
    private String nom ;
    private String prenom ;
    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
    @Column(nullable = true)
    private List<Permis> permis = new ArrayList<>();

    @OneToMany(mappedBy = "driver")
    private List<Trip>trips=new ArrayList<>();
}
