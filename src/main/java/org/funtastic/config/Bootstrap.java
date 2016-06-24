package org.funtastic.config;

import java.util.ArrayList;
import java.util.List;

import org.funtastic.entity.User;
import org.funtastic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private UserService UserService;

	private List<User> getUsers() {
		List<User> users = new ArrayList<>();
		User user = null;
		for (int i = 0; i < 10; i++) {
			user = new User();
			user.setFirstName("First Name" + i);
			user.setLastName("Last Name" + i);
			user.setEmail("coolnimesh43" + i + "@gmail.com");
			user.setPassword("nimesh");

		}
		return users;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		List<User> currentUser = this.UserService.getAll();
		if (currentUser == null || currentUser.isEmpty()) {
			for (User user : getUsers()) {
				this.UserService.save(user);
			}
		}
	}

}
