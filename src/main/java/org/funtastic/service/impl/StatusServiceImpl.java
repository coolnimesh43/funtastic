package org.funtastic.service.impl;

import java.util.List;

import org.funtastic.entity.Status;
import org.funtastic.repository.StatusRepository;
import org.funtastic.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly=true)
public class StatusServiceImpl implements StatusService {

	@Autowired
	private StatusRepository statusRepository;
	
	@Override
	public Status findById(Long id) {
		return this.statusRepository.findOne(id);
	}

	@Override
	public List<Status> getAll() {
		return this.statusRepository.findAll();
	}

	@Override
	@Transactional
	public Status save(Status r) {
		return this.statusRepository.save(r);
	}

	@Override
	@Transactional
	public void delete(Status r) {
		this.statusRepository.delete(r);
	}

	@Override
	public List<Status> findAllByUser(Long userId) {
		return this.statusRepository.findAllByUser(userId);
	}

	@Override
	public List<Status> findAllByUserAndMood(Long userId, Long moodId) {
		return this.statusRepository.findAllByUserAndMood(userId, moodId);
	}

}
