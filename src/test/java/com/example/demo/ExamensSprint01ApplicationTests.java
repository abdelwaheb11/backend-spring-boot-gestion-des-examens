package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.abdelwaheb.examens.entities.Examen;
import com.abdelwaheb.examens.repos.ExamenRepository;

@SpringBootTest
class ExamensSprint01ApplicationTests {
	@Autowired
	ExamenRepository produitRepository;

	@Test
	void contextLoads() {
	}
	@Test
	public void testFindByEtudiant()
	{
		List<Examen> ex = produitRepository.findByEtudiant("abdelwaheb");
		for (Examen e : ex)
		{
			System.out.println(e);
		}
	}
	
	@Test
	public void testFindByEtudiantContains ()
	{
	List<Examen> ex=produitRepository.findByEtudiantContains("a");
		for (Examen e : ex)
		{
			System.out.println(e);
		}
	}


}
