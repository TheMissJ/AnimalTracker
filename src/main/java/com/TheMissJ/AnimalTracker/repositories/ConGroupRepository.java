package com.TheMissJ.AnimalTracker.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.TheMissJ.AnimalTracker.models.ConGroup;

@Repository
public interface ConGroupRepository extends CrudRepository<ConGroup, Long>{

	List<ConGroup> findAll();
	boolean existsByEmail(String email);
	ConGroup findByEmail(String email);
	boolean existsByName(String name);
	
	
}
