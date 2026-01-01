package org.example.demo.Service;

import org.example.demo.Entities.Filiere;
import org.springframework.stereotype.Component;

import java.time.Year;

@Component
public class NumeroInscriptionGenerator {

    public String generate(Filiere filiere, Long eleveId) {
        String code = (filiere != null && filiere.getCode() != null && !filiere.getCode().isBlank())
                ? filiere.getCode().toUpperCase()
                : "NA";

        int annee = Year.now().getValue();
        return code + "-" + annee + "-" + eleveId;
    }
}
