package com.TheMissJ.AnimalTracker.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.TheMissJ.AnimalTracker.models.SubSpecies;

@Repository
public interface SubSpeciesRepository extends CrudRepository<SubSpecies, Long>{

	List <SubSpecies> findAll();
	boolean existsByName(String name);
}
