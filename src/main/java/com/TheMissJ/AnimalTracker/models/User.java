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
	@OneToMany(mappedBy="creator", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Giraffe> giraffes;
	
			//relationship to the group the user belongs to
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="group_id")
	private Group group;
	
			//relationship to notes written by the user for giraffe
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List <Note> notes;
	
	
	
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
	
//	@OneToMany(mappedBy="creator", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
//	private List<Idea> ideas;
//	
//	@ManyToMany(fetch=FetchType.LAZY)
//	@JoinTable(
//			name="fanlist",
//			joinColumns = @JoinColumn(name="user_id"),
//			inverseJoinColumns = @JoinColumn(name="idea_id")
//			)
//	private List<Idea> fanclicks;
	

	
	

	public User() {

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


	
	
	
	
	
	
	
}
