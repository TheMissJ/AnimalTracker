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
	@Size(max = 4)
	private int birth_year;
	
	private float height;
	private float weight;
	
	@Column(updatable=false)
	private char gender;
	
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
	
			//relationship to the tracker assigned to the giraffe
	@OneToOne(mappedBy="giraffe", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private Tracker tracker;
	
			//relationship to the species the giraffe belongs to
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="species_id", updatable=false)
	private Species species;
	
	@Column(updatable=false)
	private String subSpecies;
	
	private String mother;
	private String father;
	
	private boolean deceased;
	
	@Column(updatable=false)
	@Size(max = 4)
	private int death_year;
	
	@Column(updatable=false)
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

	public Giraffe() {
		super();
	}

	public Giraffe(@NotBlank @Size(max = 60) String name, @Size(max = 4) int birth_year, float height, float weight,
			char gender, User creator, Location location, List<Note> notes, Tracker tracker, Species species, String subSpecies) {
		super();
		this.name = name;
		this.birth_year = birth_year;
		this.height = height;
		this.weight = weight;
		this.gender = gender;
		this.giraffeCreator = giraffeCreator;
		this.location = location;
		this.notes = notes;
		this.tracker = tracker;
		this.species = species;
		this.subSpecies = subSpecies;
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

	public int getBirth_year() {
		return birth_year;
	}

	public void setBirth_year(int birth_year) {
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

	public Tracker getTracker() {
		return tracker;
	}

	public void setTracker(Tracker tracker) {
		this.tracker = tracker;
	}

	public Species getSpecies() {
		return species;
	}

	public void setSpecies(Species species) {
		this.species = species;
	}

	public String getSubSpecies() {
		return subSpecies;
	}

	public void setSubSpecies(String subSpecies) {
		this.subSpecies = subSpecies;
	}

	public String getMother() {
		return mother;
	}

	public void setMother(String mother) {
		this.mother = mother;
	}

	public String getFather() {
		return father;
	}

	public void setFather(String father) {
		this.father = father;
	}

	public boolean isDeceased() {
		return deceased;
	}

	public void setDeceased(boolean deceased) {
		this.deceased = deceased;
	}

	public int getDeath_year() {
		return death_year;
	}

	public void setDeath_year(int death_year) {
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
	
	
	
	
}
