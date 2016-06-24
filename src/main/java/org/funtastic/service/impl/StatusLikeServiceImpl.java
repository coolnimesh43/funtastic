package org.funtastic.service.impl;

import java.util.List;

import org.funtastic.entity.StatusLike;
import org.funtastic.repository.StatusLikeRepository;
import org.funtastic.service.StatusLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class StatusLikeServiceImpl implements StatusLikeService {

	@Autowired
	private StatusLikeRepository statusLikeRepository;

	@Override
	public StatusLike findById(Long id) {
		return this.statusLikeRepository.findOne(id);
	}

	@Override
	public List<StatusLike> getAll() {
		return this.statusLikeRepository.findAll();
	}

	@Override
	@Transactional
	public StatusLike save(StatusLike r) {
		return this.statusLikeRepository.save(r);
	}

	@Override
	@Transactional
	public void delete(StatusLike r) {
		this.statusLikeRepository.delete(r);
	}

	@Override
	public List<StatusLike> findAllByUser(Long userId) {
		return this.statusLikeRepository.findAllByUser(userId);
	}

	@Override
	public List<StatusLike> findAllByStatus(Long statusId) {
		return this.statusLikeRepository.findAllByStatus(statusId);
	}

}
