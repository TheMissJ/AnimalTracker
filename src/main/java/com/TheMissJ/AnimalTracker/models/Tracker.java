package com.TheMissJ.AnimalTracker.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	@DateTimeFormat(pattern = "MM-dd-YYYY HH:mm:ss")
	private Date updatedAt;

				//relationship to giraffe
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="giraffe_id")
	private Giraffe giraffe;
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}


	public Tracker() {
		super();
	}


	public Tracker(String number, @NotBlank Float lat_degrees, @NotBlank Float lat_minutes, @NotBlank Float lat_seconds,
			@NotBlank Float lon_degrees, @NotBlank Float lon_minutes, @NotBlank Float lon_seconds) {
		super();
		this.number = number;
		this.lat_degrees = lat_degrees;
		this.lat_minutes = lat_minutes;
		this.lat_seconds = lat_seconds;
		this.lon_degrees = lon_degrees;
		this.lon_minutes = lon_minutes;
		this.lon_seconds = lon_seconds;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
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
	
	
	
	
}
