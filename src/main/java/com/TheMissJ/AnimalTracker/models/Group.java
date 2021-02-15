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
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="groups")
public class Group {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max=255)
	private String name;
	
	@NotBlank
	@Email
	private String email;
	
	@Size(max=20)
	private String phone;
	
	@Size(max=255)
	private String street1;
	@Size(max=255)
	private String street2;
	@Size(max=255)
	private String city;
	@Size(max=255)
	private String state;
	@Size(max=255)
	private String country;
	@Size(max = 25)
	private String postal_code;
	
			//relationship to users who belong to this group
	@OneToMany(mappedBy="staff", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List <User> users;
	
	
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
