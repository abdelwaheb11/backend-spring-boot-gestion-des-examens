package com.abdelwaheb.examens.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@Entity
public class Examen {	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@NotNull
	@Size (min = 4,max = 60)
	private String etudiant;
	
	@Min(value = 0)
    @Max(value = 20)
	private Double note;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date date;
	
	
	@ManyToOne
	private Matiere matiere;



	public Examen() {
		super();
	}
	
	
	public Examen(String e, Double n, Date d) {
		super();
		this.etudiant = e;
		this.note = n;
		this.date = d;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(String e) {
		this.etudiant = e;
	}
	public Double getNote() {
		return note;
	}
	public void setNote(Double n) {
		this.note = n;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date d) {
		this.date = d;
	}

	

	public Matiere getMatiere() {
		return matiere;
	}


	public void setMatiere(Matiere m) {
		this.matiere = m;
	}


	@Override
	public String toString() {
		return "Examen [id=" + id + ", Etudiant=" + etudiant + ", Note=" + note
				+ ", Date=" + date + "]";
	}
	
	

}
