package com.TheMissJ.AnimalTracker.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.TheMissJ.AnimalTracker.models.Species;

@Repository
public interface SpeciesRepository extends CrudRepository<Species, Long>{

	List <Species> findAll();
	boolean existsByName(String name);
	
}
