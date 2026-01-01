package org.example.demo.Repository;

import org.example.demo.Entities.Cours;
import org.example.demo.Entities.DossierAdministratif;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DossierAdministratifRepository   extends JpaRepository<DossierAdministratif,Long> {

}
