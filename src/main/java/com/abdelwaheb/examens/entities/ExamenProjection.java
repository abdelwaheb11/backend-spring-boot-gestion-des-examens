package com.abdelwaheb.examens.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "etudiant", types = { Examen.class })
public interface ExamenProjection {
	public String getEtudiant();

}
