package com.abdelwaheb.examens.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abdelwaheb.examens.entities.Examen;
import com.abdelwaheb.examens.service.ExamenService;


@RestController
@RequestMapping("/api/examen")
@CrossOrigin
public class ExamenRESTController {
	@Autowired
	ExamenService examenService;

	@RequestMapping(value="/all" ,method = RequestMethod.GET)
	public List<Examen> getAllExamens() {
		return examenService.getAllExamens();
	}

	@RequestMapping(value = "/getAllParPage" ,method = RequestMethod.GET)
	public Page<Examen> getAllExamensParPage(@RequestParam (name="page",defaultValue = "0") int page,@RequestParam (name="size", defaultValue = "2") int size) {
		return examenService.getAllExamensParPage(page,size);
	}
	
	@RequestMapping(value="/getById/{id}",method = RequestMethod.GET)
	public Examen getExamenById(@PathVariable("id") Long id) {
		return examenService.getExamen(id);
	}
	
	@RequestMapping(value = "/save" ,method = RequestMethod.POST)
	public Examen createExamen(@RequestBody Examen examen) {
		return examenService.saveExamen(examen);
	}
	
	@RequestMapping(value = "/update" ,method = RequestMethod.PUT)
	public Examen updateExamen(@RequestBody Examen examen) {
		return examenService.updateExamen(examen);
	}
	
	@RequestMapping(value="/delete/{id}",method = RequestMethod.DELETE)
	public void deleteExamen(@PathVariable("id") Long id){
		examenService.deleteExamenById(id);
	}
	
	@RequestMapping(value="/examenParMat/{idMat}",method = RequestMethod.GET)
	public List<Examen> getExamensByMatId(@PathVariable("idMat") Long id) {
		return examenService.findByMatiereId(id);
	}

	@RequestMapping(value="/examenParEtudiant/{nom}",method = RequestMethod.GET)
	public List<Examen> getExamensByNomEtudiant(@PathVariable("nom") String nom) {
		return examenService.findByEtudiantContains(nom);
	}

}
