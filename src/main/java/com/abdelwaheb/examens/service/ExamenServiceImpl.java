package com.abdelwaheb.examens.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.abdelwaheb.examens.entities.Matiere;
import com.abdelwaheb.examens.entities.Examen;
import com.abdelwaheb.examens.repos.MatiereRepository;
import com.abdelwaheb.examens.repos.ExamenRepository;

@Service
public class ExamenServiceImpl implements ExamenService{

	@Autowired
	ExamenRepository examenRepository;
	
	
	@Autowired
	MatiereRepository matiereRepository;
	
	@Override
	public Examen saveExamen(Examen e) {
		return examenRepository.save(e);
	}

	@Override
	public Examen updateExamen(Examen e) {
		return examenRepository.save(e);
	}

	@Override
	public void deleteExamen(Examen e) {
		examenRepository.delete(e);
		
	}

	@Override
	public void deleteExamenById(Long id) {
		examenRepository.deleteById(id);
		
	}

	@Override
	public Examen getExamen(Long id) {
		return examenRepository.findById(id).get();
	}

	@Override
	public List<Examen> getAllExamens() {
		
		return examenRepository.findAll();
	}
	
	@Override
	public Page<Examen> getAllExamensParPage(int page, int size) {
		
		return examenRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<Matiere> getAllMatiere() {
		return matiereRepository.findAll();
	}
	
	@Override
	public List<Examen> findByEtudiant(String nom) {
	return examenRepository.findByEtudiant(nom);
	}
	@Override
	public List<Examen> findByEtudiantContains(String nom) {
	return examenRepository.findByEtudiantContains(nom);
	}
	@Override
	public List<Examen> findByEtudiantNote(String e, Double n) {
	return examenRepository.findByEtudiantNote(e, n);
	}
	@Override
	public List<Examen> findByMatiere(Matiere Matiere) {
	return examenRepository.findByMatiere(Matiere);
	}
	@Override
	public List<Examen> findByMatiereId(Long id) {
	return examenRepository.findByMatiereId(id);
	}
	@Override
	public List<Examen> findByOrderByEtudiantAsc() {
	return examenRepository.findByOrderByEtudiantAsc();
	}
	@Override
	public List<Examen> trierExamensEtudiantNote() {
	return examenRepository.trierExamensEtudiantNote();
	}

	
	

}
