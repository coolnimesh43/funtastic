package org.funtastic.service.impl;

import java.util.List;

import org.funtastic.entity.Group;
import org.funtastic.repository.GroupRepository;
import org.funtastic.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class GroupServiceImpl implements GroupService {

	@Autowired
	private GroupRepository groupRepository;

	@Override
	public Group findById(Long id) {
		return this.groupRepository.findOne(id);
	}

	@Override
	public List<Group> getAll() {
		return this.groupRepository.findAll();
	}

	@Override
	@Transactional
	public Group save(Group r) {
		return this.groupRepository.save(r);
	}

	@Override
	@Transactional
	public void delete(Group r) {
		this.groupRepository.delete(r);
	}

	@Override
	public List<Group> findByName(String name) {
		return this.groupRepository.findByName(name);
	}

}
