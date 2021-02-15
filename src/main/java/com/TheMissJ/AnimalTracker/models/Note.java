package com.TheMissJ.AnimalTracker.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="notes")
public class Note {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(updatable = false)
	@Size(max = 1000)
	private String content;
	
			//relationship to giraffe the note is about
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="giraffe_id")
	private Giraffe giraffe;

			//relationship to user/creator
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
		
	
	
	@Column(updatable=false)
	@DateTimeFormat(pattern = "MM-dd-YYYY HH:mm:ss")
	private Date createdAt;

	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	
	
}
	

