package com.abdelwaheb.examens;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.abdelwaheb.examens.entities.Examen;
import com.abdelwaheb.examens.entities.Matiere;
import com.abdelwaheb.examens.service.ExamenService;
 
@SpringBootApplication
public class ExamensApplication implements CommandLineRunner  {
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	
	@Override
	public void run(String... args) throws Exception {
	repositoryRestConfiguration.exposeIdsFor(Examen.class,Matiere.class);
	}

	
	@Autowired 
	ExamenService examenservice;

	public static void main(String[] args) {
		SpringApplication.run(ExamensApplication.class, args); 
	} 
	
	

}
