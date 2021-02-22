package com.TheMissJ.AnimalTracker.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.TheMissJ.AnimalTracker.models.Picture;
import com.TheMissJ.AnimalTracker.models.User;

@Repository
public interface PictureRepository extends CrudRepository<Picture, Long> {

	List<Picture> findAllByUser(User user);
}
