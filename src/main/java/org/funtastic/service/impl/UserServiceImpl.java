package org.funtastic.service.impl;


import java.util.List;

import org.funtastic.entity.User;
import org.funtastic.repository.UserRepository;
import org.funtastic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly=true)
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	@Override
	public User findById(Long id) {
		return this.userRepository.findOne(id);
	}

	@Override
	public List<User> getAll() {
		return this.userRepository.findAll();
	}

	@Override
	@Transactional
	public User save(User r) {
		return this.userRepository.save(r);
	}

	@Override
	@Transactional
	public void delete(User r) {
		this.userRepository.delete(r);
		
	}

	@Override
	public User findByEmail(String email) {
		return this.userRepository.findByEmail(email);
	}
}
