package org.example.demo;

import org.example.demo.Entities.*;
import org.example.demo.Repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner init(EleveRepository eleveRepo, FiliereRepository filiereRepo, CoursRepository coursRepo, DossierAdministratifRepository dossierRepo) {
        return args -> {
            // Créer une filière
            Filiere info = new Filiere();
            info.setCode("INFO");
            info.setNom("Informatique");
            filiereRepo.save(info);

            Filiere math = new Filiere();
            math.setCode("MATH");
            math.setNom("Mathématiques");
            filiereRepo.save(math);

            // Créer des cours
            Cours java = new Cours();
            java.setCode("JAVA101");
            java.setIntitule("Programmation Java");
            java.setFiliere(info);
            coursRepo.save(java);

            Cours algo = new Cours();
            algo.setCode("ALGO101");
            algo.setIntitule("Algorithmique");
            algo.setFiliere(info);
            coursRepo.save(algo);

            Cours calc = new Cours();
            calc.setCode("CALC201");
            calc.setIntitule("Calcul Différentiel");
            calc.setFiliere(math);
            coursRepo.save(calc);

            // Créer un élève
            Eleve eleve1 = new Eleve();
            eleve1.setNom("Dupont");
            eleve1.setPrenom("Jean");
            eleve1.setFiliere(info);
            eleve1.getCours().add(java);
            eleve1.getCours().add(algo);
            Eleve savedEleve1 = eleveRepo.save(eleve1);

            // Créer un dossier administratif
            DossierAdministratif dossier1 = new DossierAdministratif();
            dossier1.setNumeroInscription("INFO-2026-" + savedEleve1.getId());
            dossier1.setDateCreation(LocalDate.now());
            dossier1.setEleve(savedEleve1);
            dossierRepo.save(dossier1);

            // Créer un autre élève
            Eleve eleve2 = new Eleve();
            eleve2.setNom("Martin");
            eleve2.setPrenom("Sophie");
            eleve2.setFiliere(math);
            eleve2.getCours().add(calc);
            Eleve savedEleve2 = eleveRepo.save(eleve2);

            // Créer un dossier administratif
            DossierAdministratif dossier2 = new DossierAdministratif();
            dossier2.setNumeroInscription("MATH-2026-" + savedEleve2.getId());
            dossier2.setDateCreation(LocalDate.now());
            dossier2.setEleve(savedEleve2);
            dossierRepo.save(dossier2);

            System.out.println("Données de test insérées avec succès !");
        };
    }
}