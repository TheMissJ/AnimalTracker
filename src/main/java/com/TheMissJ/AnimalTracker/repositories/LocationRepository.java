package com.TheMissJ.AnimalTracker.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.TheMissJ.AnimalTracker.models.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long>{

	List <Location> findAll();
	boolean existsByName(String name);
}
