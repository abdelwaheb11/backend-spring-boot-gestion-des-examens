package com.abdelwaheb.examens.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abdelwaheb.examens.entities.Matiere;
import com.abdelwaheb.examens.repos.MatiereRepository;

@Service
public class MatiereServiceImpl implements MatiereService {

    @Autowired
    MatiereRepository matiereRepository;

    @Override
    public List<Matiere> getAllMatiere(){
        return this.matiereRepository.findAll();
    }

    @Override
    public Matiere getMatiereById(Long id){
        return this.matiereRepository.findById(id).get();
    }

    @Override
    public Matiere saveMatiere(Matiere m){
        return this.matiereRepository.save(m);
    }
    @Override
    public void deleteMatiere(Long id){
        this.matiereRepository.deleteById(id);
    }

    @Override
    public Matiere updateMatiere(Matiere m){
        return this.matiereRepository.save(m);
    }

    @Override
    public List<Matiere> searchParLabelMatiere(String s){
        return this.matiereRepository.findByLabelleContains(s);
    }

}
