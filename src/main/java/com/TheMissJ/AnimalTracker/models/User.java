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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max=60)
	private String firstName;
	
	@NotBlank
	@Size(max=60)
	private String lastName;
	
	@Email
	private String email;
	private String password;
	
	@Transient
	private String confirmPassword;
	
			//relationship to the giraffe records the user has created
	@OneToMany(mappedBy="giraffeCreator", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Giraffe> giraffes;
	
			//relationship to the user who updated a giraffe
	@OneToMany(mappedBy="updatedBy", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List <Giraffe> giraffeUpdated;
	
			//relationship to the group the user belongs to
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="group_id")
	private ConGroup employer;
	

	//relationship to notes written by the user for giraffe
	@OneToMany(mappedBy="noteCreator", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List <Note> userNotes;
	
	
	
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
	
	

	public User() {
		super();
	}

	public User(@NotBlank @Size(max = 60) String firstName, @NotBlank @Size(max = 60) String lastName,
			@Email String email, String password, String confirmPassword, List<Giraffe> giraffes,
			List<ConGroup> groupsCreated, ConGroup employer, List<Note> userNotes) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.giraffes = giraffes;
		this.employer = employer;
		this.userNotes = userNotes;
	}

	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public List<Giraffe> getGiraffes() {
		return giraffes;
	}

	public void setGiraffes(List<Giraffe> giraffes) {
		this.giraffes = giraffes;
	}

	public List<Giraffe> getGiraffeUpdated() {
		return giraffeUpdated;
	}

	public void setGiraffeUpdated(List<Giraffe> giraffeUpdated) {
		this.giraffeUpdated = giraffeUpdated;
	}

	public ConGroup getEmployer() {
		return employer;
	}

	
	public List<Note> getUserNotes() {
		return userNotes;
	}

	public void setUserNotes(List<Note> userNotes) {
		this.userNotes = userNotes;
	}

	public void setEmployer(ConGroup employer) {
		this.employer = employer;
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
