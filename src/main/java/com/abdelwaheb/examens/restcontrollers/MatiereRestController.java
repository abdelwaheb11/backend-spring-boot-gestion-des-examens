package com.abdelwaheb.examens.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abdelwaheb.examens.entities.Matiere;
import com.abdelwaheb.examens.service.MatiereService;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@RequestMapping("/api/matieres")
@CrossOrigin
public class MatiereRestController {

    @Autowired
    MatiereService matiereService;

    @RequestMapping(value ="/all", method=RequestMethod.GET)
    public List<Matiere> getAllMatieres() {
        return this.matiereService.getAllMatiere();
    }

    @RequestMapping(value ="/getById/{id}", method=RequestMethod.GET)
    public Matiere getMatiereById(@PathVariable("id") Long id) {
        return this.matiereService.getMatiereById(id);
    }

    @RequestMapping(value ="/save", method=RequestMethod.POST)
    public Matiere saveMatiere( @RequestBody Matiere matiere ) {
        return this.matiereService.saveMatiere(matiere);
    }

    @RequestMapping(value ="/update", method=RequestMethod.PUT)
    public Matiere updateMatiere( @RequestBody Matiere matiere ) {
        return this.matiereService.updateMatiere(matiere);
    }

    @RequestMapping(value ="/delete/{id}", method=RequestMethod.DELETE)
    public void deleteMatiere( @PathVariable("id") Long id) {
        this.matiereService.deleteMatiere(id);
    }

    @RequestMapping(value ="/matieresParLabelle/{labelle}", method=RequestMethod.GET)
    public List<Matiere> searchMatiereByLabelle( @PathVariable("labelle") String labelle ) {
        return this.matiereService.searchParLabelMatiere(labelle);
    }

    

}
