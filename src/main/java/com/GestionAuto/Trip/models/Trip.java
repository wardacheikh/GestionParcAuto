package com.GestionAuto.Trip.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(nullable = false)
    private String depanature ;
    @Column(nullable = false)
    private String destination ;
    @Column(nullable = false)
    private LocalDate departureDate ;
    @Column(nullable = false)
    private LocalTime departureTime;
    @Column(nullable = false)
    private LocalDate arrivalDate ;
    @Column(nullable = false)
    private LocalTime arrivalTime;
    @Column(nullable = false)
    private int numberOfPassangers ;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private VehiculeType vehiculeType ;

    @ManyToOne
    @JoinColumn(name="matricule")
    private Driver driver ;

}
