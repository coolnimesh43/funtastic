package org.funtastic.config;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.funtastic.entity.User;
import org.funtastic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private static final Logger LOG = LogManager.getLogger(Bootstrap.class);
	@Autowired
	private UserService userService;

	private List<User> getUsers() {
		List<User> users = new ArrayList<>();
		User user = null;
		for (int i = 0; i < 10; i++) {
			user = new User();
			user.setFirstName("First Name" + i);
			user.setLastName("Last Name" + i);
			user.setEmail("coolnimesh43" + i + "@gmail.com");
			user.setPassword("nimesh");
			users.add(user);
		}
		return users;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		LOG.debug("Bootstrap#creating user");
		List<User> currentUser = this.userService.getAll();
		if (currentUser == null || currentUser.isEmpty()) {
			for (User user : getUsers()) {
				User user1 = this.userService.save(user);
			}
		}
	}

}
