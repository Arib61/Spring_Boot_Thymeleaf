package org.example.demo.Repository;

import org.example.demo.Entities.Eleve;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EleveRepository extends JpaRepository<Eleve,Long> {

}
