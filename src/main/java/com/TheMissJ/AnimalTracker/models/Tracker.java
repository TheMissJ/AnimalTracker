package com.TheMissJ.AnimalTracker.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="trackers")
public class Tracker {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	

	private String number;
	
	@NotBlank
	private Float lat_degrees;
	@NotBlank
	private Float lat_minutes;
	@NotBlank
	private Float lat_seconds;
	
	@NotBlank
	private Float lon_degrees;
	@NotBlank
	private Float lon_minutes;
	@NotBlank
	private Float lon_seconds;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern = "MM-dd-YYYY HH:mm:ss")
	private Date createdAt;

	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
}
