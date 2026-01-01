package org.example.demo.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity
public class DossierAdministratif {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroInscription;
    private LocalDate dateCreation;

    @OneToOne
    @JoinColumn(name = "eleve_id", unique = true)
    private Eleve eleve;
}
