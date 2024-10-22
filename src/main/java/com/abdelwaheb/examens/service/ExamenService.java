package com.abdelwaheb.examens.service;
import java.util.List;

import org.springframework.data.domain.Page;

import com.abdelwaheb.examens.entities.Matiere;
import com.abdelwaheb.examens.entities.Examen;

public interface ExamenService {
	Examen saveExamen(Examen p);
	Examen updateExamen(Examen p);
	void deleteExamen(Examen p);
	void deleteExamenById(Long id);
	Examen getExamen(Long id);
	List<Examen> getAllExamens();
	Page<Examen> getAllExamensParPage(int page, int size);
	List<Matiere> getAllMatiere();
	
	List<Examen> findByEtudiant(String e);
	List<Examen> findByEtudiantContains(String e);
	List<Examen> findByEtudiantNote (String e, Double n);
	List<Examen> findByMatiere (Matiere m);
	List<Examen> findByMatiereId(Long id);
	List<Examen> findByOrderByEtudiantAsc();
	List<Examen> trierExamensEtudiantNote();

	


}
