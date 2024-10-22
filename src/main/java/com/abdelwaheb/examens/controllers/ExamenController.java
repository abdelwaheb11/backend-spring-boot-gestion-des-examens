package com.abdelwaheb.examens.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.abdelwaheb.examens.entities.Matiere;
import com.abdelwaheb.examens.entities.Examen;
import com.abdelwaheb.examens.service.ExamenService;

import jakarta.validation.Valid;

@Controller
public class ExamenController {
	@Autowired
	ExamenService examenservice;
	
	
		   @RequestMapping("/ListeExamens")
			public String listeexamens(ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,@RequestParam (name="size", defaultValue = "2") int size)
			{
			    Page<Examen> ex = examenservice.getAllExamensParPage(page, size);
				modelMap.addAttribute("examens", ex);
		        modelMap.addAttribute("pages", new int[ex.getTotalPages()]);	
				modelMap.addAttribute("currentPage", page);			
				return "listeExamen";	
			}


		   @RequestMapping("/showCreate")
			public String showCreate(ModelMap modelMap)
			{
				modelMap.addAttribute("examen", new Examen());
				List<Matiere> cats = examenservice.getAllMatiere();
				modelMap.addAttribute("mode", "new");
				modelMap.addAttribute("matieres", cats);
				return "formExamen";
			}
		   
		   
			


		   @RequestMapping("/saveExamen")
			public String saveExamen(@Valid Examen examen, BindingResult bindingResult,
					@RequestParam (name="page",defaultValue = "0") int page,
					@RequestParam (name="size", defaultValue = "2") int size)
			{
				int currentPage;
				boolean isNew = false;
			   if (bindingResult.hasErrors()) return "formExamen";				  
				
			   if(examen.getId()==null) //ajout
				    isNew=true;
			  			   
			  	examenservice.saveExamen(examen);
			  	if (isNew) //ajout
			  	{
			  		Page<Examen> exams = examenservice.getAllExamensParPage(page, size);
			  		currentPage = exams.getTotalPages()-1;
			  	}
			  	else //modif
			  		currentPage=page;
			  	
			  	
				//return "formExamen";
				return ("redirect:/ListeExamens?page="+currentPage+"&size="+size);
			}


	  @RequestMapping("/supprimerExamen")
		public String supprimerExamen(@RequestParam("id") Long id,
				ModelMap modelMap,
				@RequestParam (name="page",defaultValue = "0") int page,
				@RequestParam (name="size", defaultValue = "2") int size)
		{

			examenservice.deleteExamenById(id);
			Page<Examen> prods = examenservice.getAllExamensParPage(page, size);
			modelMap.addAttribute("examens", prods);		
			modelMap.addAttribute("pages", new int[prods.getTotalPages()]);	
			modelMap.addAttribute("currentPage", page);	
			modelMap.addAttribute("size", size);	
			return "listeExamen";	
		}


	@RequestMapping("/modifierExamen")
	public String editerExamen(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size) {
		Examen e = examenservice.getExamen(id);
		List<Matiere> mats = examenservice.getAllMatiere();
		modelMap.addAttribute("mode", "edit");
		modelMap.addAttribute("examen", e);
		modelMap.addAttribute("matieres", mats);
		modelMap.addAttribute("page", page);
		modelMap.addAttribute("size", size);
		
		return "formExamen";
	}
	  
	

	@RequestMapping("/updateExamen")
	public String updateExamen(@ModelAttribute("Examen") Examen Examen, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {
		// conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		Examen.setDate(dateCreation);

		examenservice.updateExamen(Examen);
		List<Examen> ex = examenservice.getAllExamens();
		modelMap.addAttribute("examens", ex);
		return "listeExamens";
	}
}
