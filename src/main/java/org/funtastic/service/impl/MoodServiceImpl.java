package org.funtastic.service.impl;

import java.util.List;

import org.funtastic.entity.Mood;
import org.funtastic.repository.MoodRepository;
import org.funtastic.service.MoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly=true)
public class MoodServiceImpl implements MoodService {

	@Autowired
	private MoodRepository moodRepository;
	@Override
	public Mood findById(Long id) {
		return this.moodRepository.findOne(id);
	}

	@Override
	public List<Mood> getAll() {
		return this.moodRepository.findAll();
	}

	@Override
	@Transactional
	public Mood save(Mood r) {
		return this.moodRepository.save(r);
	}

	@Override
	@Transactional
	public void delete(Mood r) {
		this.moodRepository.delete(r);
	}

}
