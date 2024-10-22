package com.abdelwaheb.examens.service;

import java.util.List;

import com.abdelwaheb.examens.entities.Matiere;

public interface MatiereService {
    List<Matiere> getAllMatiere();
    Matiere getMatiereById( Long id);
    Matiere saveMatiere(Matiere m);
    Matiere updateMatiere(Matiere m);
    void deleteMatiere(Long m);
    List<Matiere> searchParLabelMatiere(String m);
}
