package com.TheMissJ.AnimalTracker.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.TheMissJ.AnimalTracker.models.Note;

@Repository
public interface NoteRepository extends CrudRepository<Note, Long>{

	List <Note> findAll();
}
