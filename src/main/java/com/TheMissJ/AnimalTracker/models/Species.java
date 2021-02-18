package com.TheMissJ.AnimalTracker.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="species")
public class Species {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
			// Relationship to a giraffe
	@OneToMany(mappedBy="species", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List <Giraffe> giraffeInSpecies;
	
			//relationship to the sub_species, if one exists
	@OneToMany(mappedBy="species", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List <SubSpecies> mySubSpecies;

	@Column(updatable=false)
	@DateTimeFormat(pattern = "MM-dd-YYYY HH:mm:ss")
	private Date createdAt;
	@DateTimeFormat(pattern = "MM-dd-YYYY HH:mm:ss")
	private Date updatedAt;

	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}


	public Species() {
		super();
	}


	public Species(String name, List<SubSpecies> sub_species) {
		super();
		this.name = name;
		this.mySubSpecies = mySubSpecies;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}



	public List<Giraffe> getGiraffeInSpecies() {
		return giraffeInSpecies;
	}


	public void setGiraffeInSpecies(List<Giraffe> giraffeInSpecies) {
		this.giraffeInSpecies = giraffeInSpecies;
	}


	public List<SubSpecies> getMySubSpecies() {
		return mySubSpecies;
	}


	public void setMySubSpecies(List<SubSpecies> mySubSpecies) {
		this.mySubSpecies = mySubSpecies;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	
	
	
}
