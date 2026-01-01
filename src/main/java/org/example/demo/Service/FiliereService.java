package org.example.demo.Service;

import org.example.demo.Entities.Filiere;
import org.example.demo.Repository.FiliereRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FiliereService {

    private final FiliereRepository filiereRepository;

    public FiliereService(FiliereRepository filiereRepository) {
        this.filiereRepository = filiereRepository;
    }

    public List<Filiere> findAll() {
        return filiereRepository.findAll();
    }

    public Filiere findById(Long id) {
        return filiereRepository.findById(id).orElseThrow(() -> new RuntimeException("Filière introuvable"));
    }

    public Filiere save(Filiere f) {
        return filiereRepository.save(f);
    }

    public void delete(Long id) {
        filiereRepository.deleteById(id);
    }
}
