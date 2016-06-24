package org.funtastic.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.funtastic.entity.User;
import org.funtastic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserLoginServiceImpl implements UserDetailsService {

	private static final Logger LOG = LogManager.getLogger(CustomUserLoginServiceImpl.class);

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		LOG.debug("Inside CustomUserLoginServiceImpl#loadUserByUserName method.");
		User user = this.userService.findByEmail(userName);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid UserName");
		}

		return null;
	}

}
