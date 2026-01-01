package org.example.demo.Service;

import org.example.demo.Entities.Cours;
import org.example.demo.Entities.Filiere;
import org.example.demo.Repository.CoursRepository;
import org.example.demo.Repository.FiliereRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursService {

    private final CoursRepository coursRepository;
    private final FiliereRepository filiereRepository;

    public CoursService(CoursRepository coursRepository, FiliereRepository filiereRepository) {
        this.coursRepository = coursRepository;
        this.filiereRepository = filiereRepository;
    }

    public List<Cours> findAll() {
        return coursRepository.findAll();
    }

    public Cours findById(Long id) {
        return coursRepository.findById(id).orElseThrow(() -> new RuntimeException("Cours introuvable"));
    }

    public Cours save(String code, String intitule, Long filiereId) {
        Filiere filiere = (filiereId != null)
                ? filiereRepository.findById(filiereId).orElseThrow(() -> new RuntimeException("Filière introuvable"))
                : null;

        Cours c = new Cours();
        c.setCode(code);
        c.setIntitule(intitule);
        c.setFiliere(filiere);
        return coursRepository.save(c);
    }

    public Cours update(Long id, String code, String intitule, Long filiereId) {
        Cours c = findById(id);

        Filiere filiere = (filiereId != null)
                ? filiereRepository.findById(filiereId).orElseThrow(() -> new RuntimeException("Filière introuvable"))
                : null;

        c.setCode(code);
        c.setIntitule(intitule);
        c.setFiliere(filiere);
        return coursRepository.save(c);
    }

    public void delete(Long id) {
        coursRepository.deleteById(id);
    }
}
