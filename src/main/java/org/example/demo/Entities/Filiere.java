package org.example.demo.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity
public class Filiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private String nom;

    @OneToMany(mappedBy = "filiere")
    private List<Eleve> eleves = new ArrayList<>();

    @OneToMany(mappedBy = "filiere")
    private List<Cours> cours = new ArrayList<>();
}
