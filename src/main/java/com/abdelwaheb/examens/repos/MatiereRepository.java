package com.abdelwaheb.examens.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


import com.abdelwaheb.examens.entities.Matiere;

@RepositoryRestResource(path = "matiere")
@CrossOrigin("http://localhost:4200/")
public interface MatiereRepository extends JpaRepository<Matiere, Long> {
    List<Matiere> findByLabelleContains(String l); 
}
