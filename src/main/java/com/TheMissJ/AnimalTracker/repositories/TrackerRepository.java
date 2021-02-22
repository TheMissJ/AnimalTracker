package com.TheMissJ.AnimalTracker.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.TheMissJ.AnimalTracker.models.Tracker;

@Repository
public interface TrackerRepository extends CrudRepository<Tracker, Long>{

	List <Tracker> findAll();

	boolean existsByName(String name);
}
