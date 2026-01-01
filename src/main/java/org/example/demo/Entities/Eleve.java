package org.example.demo.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity
public class Eleve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;

    @ManyToOne
    @JoinColumn(name = "filiere_id")
    private Filiere filiere;

    @ManyToMany
    @JoinTable(
            name = "eleve_cours",
            joinColumns = @JoinColumn(name = "eleve_id"),
            inverseJoinColumns = @JoinColumn(name = "cours_id")
    )
    private List<Cours> cours = new ArrayList<>();

    @OneToOne(mappedBy = "eleve", cascade = CascadeType.ALL, orphanRemoval = true)
    private DossierAdministratif dossierAdministratif;

    public void setDossierAdministratif(DossierAdministratif d) {
        this.dossierAdministratif = d;
        if (d != null) d.setEleve(this);
    }
}
