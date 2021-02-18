package com.TheMissJ.AnimalTracker.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.TheMissJ.AnimalTracker.models.Giraffe;

@Repository
public interface GiraffeRepository extends CrudRepository<Giraffe, Long>{

	List<Giraffe> findAll();

}
