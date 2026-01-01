package org.example.demo.Repository;

import org.example.demo.Entities.Cours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursRepository  extends JpaRepository<Cours,Long> {

}
