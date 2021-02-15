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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="locations")
public class Location {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
			//relationship to giraffe showing which giraffe in each location
	@OneToMany(mappedBy="location", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List <Giraffe> giraffes;
	
	
	
	
	@Column(updatable=false)
	@DateTimeFormat(pattern = "MM-dd-YYYY HH:mm:ss")
	private Date createdAt;

	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	

}
