package com.TheMissJ.AnimalTracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TheMissJ.AnimalTracker.models.Note;
import com.TheMissJ.AnimalTracker.repositories.GiraffeRepository;
import com.TheMissJ.AnimalTracker.repositories.NoteRepository;
import com.TheMissJ.AnimalTracker.repositories.UserRepository;

@Service
public class NoteService {

	@Autowired
	private NoteRepository nRepo;
	
	@Autowired
	private UserRepository uRepo;
	
	@Autowired
	private GiraffeRepository gRepo;
	
	
	public List<Note> getNotes(){
		return this.nRepo.findAll();
		
	}
	
	public Note getById(Long id) {
		return this.nRepo.findById(id).orElse(null);
	}
	
	public Note create(Note note) {
		return this.nRepo.save(note);
	}
	

	
	public void deleteNote(Long id) {
		this.nRepo.deleteById(id);
		
	}
	
	
}
