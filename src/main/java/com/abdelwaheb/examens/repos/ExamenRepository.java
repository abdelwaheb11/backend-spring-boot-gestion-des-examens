package com.abdelwaheb.examens.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.abdelwaheb.examens.entities.Examen;
import com.abdelwaheb.examens.entities.Matiere;
 
@RepositoryRestResource(path = "rest")
public interface ExamenRepository extends JpaRepository<Examen, Long> {
	List<Examen> findByEtudiant(String e);
	List<Examen> findByEtudiantContains(String e); 
	
	@Query("select e from Examen e where e.etudiant like %:etu and e.note > :note")
	List<Examen> findByEtudiantNote (@Param("etu") String etu,@Param("note") Double note);
	
	@Query("select e from Examen e where e.matiere = ?1")
	List<Examen> findByMatiere (Matiere mat);
	
	List<Examen> findByMatiereId(Long id);
	
	List<Examen> findByOrderByEtudiantAsc();
	
	@Query("select e from Examen e order by e.etudiant ASC, e.note DESC")
	List<Examen> trierExamensEtudiantNote ();



 
}
