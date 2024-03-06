package com.GestionAuto.Trip.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Data
@Entity
public class Permis {
    @Id
    private Long id ;
    private PermisType type;
    private LocalDate dateReception;
    @ManyToOne
    private Driver driver;

}
