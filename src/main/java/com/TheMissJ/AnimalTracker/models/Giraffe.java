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
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="giraffes")
public class Giraffe {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max=60)
	private String name;
	
	@Size(max = 4)
	private int birth_year;
	
	private float height;
	private float weight;
	
	private char gender;
	
			//relationship to the user who created the giraffe
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User creator;
	
	
			//relationship to the location of the giraffe
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="location_id")
	private Location location;
	
			//relationship to notes written about the giraffe
	@OneToMany(mappedBy="giraffe", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List <Note> notes;
	
			//relationship to the tracker assigned to the giraffe
	@OneToOne(mappedBy="giraffe", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private Tracker tracker;
	
			//relationship to the species the giraffe belongs to
	@OneToOne(mappedBy="giraffe", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Species species;
	
	
	@Column(updatable=false)
	@DateTimeFormat(pattern = "MM-dd-YYYY HH:mm:ss")
	private Date createdAt;
	@DateTimeFormat(pattern = "MM-dd-YYYY HH:mm:ss")
	private Date updatedAt;
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	
	
	
}
