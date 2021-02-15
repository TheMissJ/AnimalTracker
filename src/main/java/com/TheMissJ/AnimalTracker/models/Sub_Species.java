package com.TheMissJ.AnimalTracker.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="sub_species")
public class Sub_Species {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
			//relationship to the species this sub_species belongs to
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="species_id")
	private Species species;
	

	@Column(updatable=false)
	@DateTimeFormat(pattern = "MM-dd-YYYY HH:mm:ss")
	private Date createdAt;

	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
}
