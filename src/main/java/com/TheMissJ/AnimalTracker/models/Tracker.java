package com.TheMissJ.AnimalTracker.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
	
	private String name;
	
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
	
	//relationship to giraffe (non-owning side)
	@OneToOne(mappedBy="myTracker", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Giraffe trackerGiraffe;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern = "MM-dd-YYYY HH:mm:ss")
	private Date createdAt;
	@DateTimeFormat(pattern = "MM-dd-YYYY HH:mm:ss")
	private Date updatedAt;

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

			//Constructors
	public Tracker() {
		super();
	}

	public Tracker(Long id, String name, @NotBlank Float lat_degrees, @NotBlank Float lat_minutes,
			@NotBlank Float lat_seconds, @NotBlank Float lon_degrees, @NotBlank Float lon_minutes,
			@NotBlank Float lon_seconds, Giraffe trackerGiraffe, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.lat_degrees = lat_degrees;
		this.lat_minutes = lat_minutes;
		this.lat_seconds = lat_seconds;
		this.lon_degrees = lon_degrees;
		this.lon_minutes = lon_minutes;
		this.lon_seconds = lon_seconds;
		this.trackerGiraffe = trackerGiraffe;
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

	public Float getLat_degrees() {
		return lat_degrees;
	}

	public void setLat_degrees(Float lat_degrees) {
		this.lat_degrees = lat_degrees;
	}

	public Float getLat_minutes() {
		return lat_minutes;
	}

	public void setLat_minutes(Float lat_minutes) {
		this.lat_minutes = lat_minutes;
	}

	public Float getLat_seconds() {
		return lat_seconds;
	}

	public void setLat_seconds(Float lat_seconds) {
		this.lat_seconds = lat_seconds;
	}

	public Float getLon_degrees() {
		return lon_degrees;
	}

	public void setLon_degrees(Float lon_degrees) {
		this.lon_degrees = lon_degrees;
	}

	public Float getLon_minutes() {
		return lon_minutes;
	}

	public void setLon_minutes(Float lon_minutes) {
		this.lon_minutes = lon_minutes;
	}

	public Float getLon_seconds() {
		return lon_seconds;
	}

	public void setLon_seconds(Float lon_seconds) {
		this.lon_seconds = lon_seconds;
	}

	public Giraffe getTrackerGiraffe() {
		return trackerGiraffe;
	}

	public void setTrackerGiraffe(Giraffe trackerGiraffe) {
		this.trackerGiraffe = trackerGiraffe;
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

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	

}
