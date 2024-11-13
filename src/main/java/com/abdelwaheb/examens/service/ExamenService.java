package com.abdelwaheb.examens.service;
import java.util.List;

import org.springframework.data.domain.Page;
import com.abdelwaheb.examens.entities.Matiere;
import com.abdelwaheb.examens.entities.Examen;
import com.abdelwaheb.examens.entities.Image;

public interface ExamenService {
	Examen saveExamen(Examen e);
	Examen updateExamen(Examen e  , List<Image> images);
	void deleteExamen(Examen e);
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
