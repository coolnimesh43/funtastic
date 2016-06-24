package org.funtastic.service.impl;

import java.util.List;

import org.funtastic.entity.Image;
import org.funtastic.repository.ImageRepository;
import org.funtastic.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageRepository imageRepository;
	
	@Override
	public Image findById(Long id) {
		return this.imageRepository.findOne(id);
	}

	@Override
	public List<Image> getAll() {
		return this.imageRepository.findAll();
	}

	@Override
	@Transactional
	public Image save(Image r) {
		return this.imageRepository.save(r);
	}

	@Override
	@Transactional
	public void delete(Image r) {
		this.imageRepository.delete(r);
	}

}
