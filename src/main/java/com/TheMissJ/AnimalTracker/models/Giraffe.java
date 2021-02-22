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
	@Column(updatable=false)
	@Size(max=60)
	private String name;
	
	@Column(updatable=false)
	@Size(min = 4, max = 4)
	private String birth_year;
	
	private float height;
	private float weight;
	
	private char gender;
	
	private String species;
	
			//relationship to the user who created the giraffe
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id", updatable=false)
	private User giraffeCreator;
	
			//relationship showing who last updated the giraffe
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="updated_user_id")
	private User updatedBy;
	
	
			//relationship to the location of the giraffe
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="location_id")
	private Location location;
	
			//relationship to notes written about the giraffe
	@OneToMany(mappedBy="giraffe", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List <Note> notes;
	
			//relationship to the tracker assigned to the giraffe (owning side)
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tracker_id")
	private Tracker myTracker;
	
		//relationship from a giraffe to its mother
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="mother_id")
	private Giraffe mother;
	
		//relationship from a mother giraffe to its child(ren)
	@OneToMany(mappedBy="mother", cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Giraffe> momkids;
	
		//relationship from a giraffe to its father
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="father_id")
	private Giraffe father;
	
		//relationship from a father giraffe to its child(ren)
	@OneToMany(mappedBy="father", cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Giraffe> dadkids;
	
	@Column(nullable=true)
	private boolean deceased;
	
	@Column(nullable=true, updatable=false)
	private String death_year;
	
	@Column(nullable=true, updatable=false)
	private String deathCause;
	
	
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

	
				//Constructors
	
	public Giraffe() {
		super();
	}



			public Giraffe(Long id, @NotBlank @Size(max = 60) String name,
						@Size(min = 4, max = 4) String birth_year, float height, float weight, char gender,
						String species, User giraffeCreator, User updatedBy, Location location, List<Note> notes,
						Tracker myTracker, Giraffe mother, List<Giraffe> momkids, Giraffe father, List<Giraffe> dadkids,
						boolean deceased, String death_year, String deathCause, Date createdAt, Date updatedAt) {
					super();
					this.id = id;
					this.name = name;
					this.birth_year = birth_year;
					this.height = height;
					this.weight = weight;
					this.gender = gender;
					this.species = species;
					this.giraffeCreator = giraffeCreator;
					this.updatedBy = updatedBy;
					this.location = location;
					this.notes = notes;
					this.myTracker = myTracker;
					this.mother = mother;
					this.momkids = momkids;
					this.father = father;
					this.dadkids = dadkids;
					this.deceased = deceased;
					this.death_year = death_year;
					this.deathCause = deathCause;
					this.createdAt = createdAt;
					this.updatedAt = updatedAt;
				}

			//Getters and Setters
	
	
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



	public String getBirth_year() {
		return birth_year;
	}

	public void setBirth_year(String birth_year) {
		this.birth_year = birth_year;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}



	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public User getGiraffeCreator() {
		return giraffeCreator;
	}

	public void setGiraffeCreator(User giraffeCreator) {
		this.giraffeCreator = giraffeCreator;
	}

	public User getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(User updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public Tracker getMyTracker() {
		return myTracker;
	}

	public void setMyTracker(Tracker myTracker) {
		this.myTracker = myTracker;
	}

	public Giraffe getMother() {
		return mother;
	}

	public void setMother(Giraffe mother) {
		this.mother = mother;
	}

	public List<Giraffe> getMomkids() {
		return momkids;
	}

	public void setMomkids(List<Giraffe> momkids) {
		this.momkids = momkids;
	}

	public Giraffe getFather() {
		return father;
	}

	public void setFather(Giraffe father) {
		this.father = father;
	}

	public List<Giraffe> getDadkids() {
		return dadkids;
	}

	public void setDadkids(List<Giraffe> dadkids) {
		this.dadkids = dadkids;
	}

	public boolean isDeceased() {
		return deceased;
	}

	public void setDeceased(boolean deceased) {
		this.deceased = deceased;
	}

	public String getDeath_year() {
		return death_year;
	}

	public void setDeath_year(String death_year) {
		this.death_year = death_year;
	}

	public String getDeathCause() {
		return deathCause;
	}

	public void setDeathCause(String deathCause) {
		this.deathCause = deathCause;
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

	public void setLocation(Object attribute) {
		// TODO Auto-generated method stub
		
	}

	public void setTracker(Object attribute) {
		// TODO Auto-generated method stub
		
	}

	public void setMyTracker(Object attribute) {
		// TODO Auto-generated method stub
		
	}

	public void setMother(Object attribute) {
		// TODO Auto-generated method stub
		
	}

	public void setFather(Object attribute) {
		// TODO Auto-generated method stub
		
	}

	public void setHeight(Object attribute) {
		// TODO Auto-generated method stub
		
	}

	public void setWeight(Object attribute) {
		// TODO Auto-generated method stub
		
	}

	public void setDeceased(Object attribute) {
		// TODO Auto-generated method stub
		
	}

	public void setDeath_year(Object attribute) {
		// TODO Auto-generated method stub
		
	}

	public void setDeathCause(Object attribute) {
		// TODO Auto-generated method stub
		
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setSpecies(Object attribute) {
		// TODO Auto-generated method stub
		
	}

	public void setGender(Object attribute) {
		// TODO Auto-generated method stub
		
	}

	public void setBirth_year(Object attribute) {
		// TODO Auto-generated method stub
		
	}


	
	
	
	
}
