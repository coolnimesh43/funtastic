package org.funtastic.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.funtastic.entity.User;
import org.funtastic.pojo.AuditUser;
import org.funtastic.pojo.UserDTO;
import org.funtastic.repository.UserRepository;
import org.funtastic.service.UserAuthService;
import org.funtastic.service.UserService;
import org.funtastic.utility.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService, UserAuthService {

	private static final Logger LOG = LogManager.getLogger(UserServiceImpl.class);
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

	@Override
	public Boolean validateUser(UserDTO userDTO) {
		LOG.debug("Inside UserServiceImpl#ValidateUser method.");
		boolean isValid = userDTO.getPassword().equals(userDTO.getRePassword());
		isValid = isValid && AppUtils.validateEmail(userDTO.getEmail());
		isValid = isValid && !StringUtils.isEmpty(userDTO.getFirstName())
				&& !StringUtils.isEmpty(userDTO.getLastName());
		return isValid;
	}

	@Override
	public User create(UserDTO userDTO) {
		LOG.debug("Inside UserServiceImpl#create method. User is: {}", userDTO);
		User user = new User(userDTO.getFirstName(), userDTO.getLastName(), userDTO.getEmail(), userDTO.getPassword());
		return this.save(user);
	}

	@Override
	public User getLoggedInUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		AuditUser user = (AuditUser) authentication.getPrincipal();
		if (user == null) {
			return null;
		}
		return this.findById(user.getId());
	}
}
