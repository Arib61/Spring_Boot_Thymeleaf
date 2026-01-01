package org.example.demo.Service;

import org.example.demo.Entities.*;
import org.example.demo.Repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class EleveService {

    private final EleveRepository eleveRepository;
    private final FiliereRepository filiereRepository;
    private final CoursRepository coursRepository;
    private final DossierAdministratifRepository dossierRepository;
    private final NumeroInscriptionGenerator generator;

    public EleveService(EleveRepository eleveRepository,
                        FiliereRepository filiereRepository,
                        CoursRepository coursRepository,
                        DossierAdministratifRepository dossierRepository,
                        NumeroInscriptionGenerator generator) {
        this.eleveRepository = eleveRepository;
        this.filiereRepository = filiereRepository;
        this.coursRepository = coursRepository;
        this.dossierRepository = dossierRepository;
        this.generator = generator;
    }

    public List<Eleve> findAll() {
        return eleveRepository.findAll();
    }

    public Eleve findById(Long id) {
        return eleveRepository.findById(id).orElseThrow(() -> new RuntimeException("Élève introuvable"));
    }

    @Transactional
    public Eleve createEleve(String nom, String prenom, Long filiereId, List<Long> coursIds) {
        Filiere filiere = (filiereId != null)
                ? filiereRepository.findById(filiereId).orElseThrow(() -> new RuntimeException("Filière introuvable"))
                : null;

        Eleve e = new Eleve();
        e.setNom(nom);
        e.setPrenom(prenom);
        e.setFiliere(filiere);

        if (coursIds != null && !coursIds.isEmpty()) {
            List<Cours> cours = coursRepository.findAllById(coursIds);
            e.setCours(cours);
        }

        // 1) save eleve first to get ID
        e = eleveRepository.save(e);

        // 2) auto-create dossier
        DossierAdministratif d = new DossierAdministratif();
        d.setDateCreation(LocalDate.now());
        d.setNumeroInscription(generator.generate(e.getFiliere(), e.getId()));
        e.setDossierAdministratif(d); // sets both sides
        // thanks to cascade ALL -> save with eleve
        return eleveRepository.save(e);
    }

    @Transactional
    public Eleve updateEleve(Long id, String nom, String prenom, Long filiereId, List<Long> coursIds) {
        Eleve e = findById(id);

        Filiere filiere = (filiereId != null)
                ? filiereRepository.findById(filiereId).orElseThrow(() -> new RuntimeException("Filière introuvable"))
                : null;

        e.setNom(nom);
        e.setPrenom(prenom);
        e.setFiliere(filiere);

        e.getCours().clear();
        if (coursIds != null && !coursIds.isEmpty()) {
            e.getCours().addAll(coursRepository.findAllById(coursIds));
        }

        // si filière a changé => regen numero
        if (e.getDossierAdministratif() != null) {
            e.getDossierAdministratif().setNumeroInscription(generator.generate(e.getFiliere(), e.getId()));
        }

        return eleveRepository.save(e);
    }

    public void deleteEleve(Long id) {
        eleveRepository.deleteById(id);
    }
}
