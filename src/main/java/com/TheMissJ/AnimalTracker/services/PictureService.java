package com.TheMissJ.AnimalTracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TheMissJ.AnimalTracker.models.Picture;
import com.TheMissJ.AnimalTracker.models.User;
import com.TheMissJ.AnimalTracker.repositories.PictureRepository;

@Service
public class PictureService {

	@Autowired
	private PictureRepository pRepo;

	public void uploadPic(User user, String url) {
		Picture newPic = new Picture(url, user);
		this.pRepo.save(newPic);
	}
	
	public List<Picture> userPictures(User user){
		return this.pRepo.findAllByUser(user);
	}
}
