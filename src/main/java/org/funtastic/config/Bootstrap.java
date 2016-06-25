package org.funtastic.config;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.funtastic.entity.Group;
import org.funtastic.entity.Mood;
import org.funtastic.entity.User;
import org.funtastic.service.GroupService;
import org.funtastic.service.MoodService;
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

	@Autowired
	private GroupService groupService;

	@Autowired
	private MoodService moodService;

	private User getUsers() {
		User user = new User();
		user.setFirstName("First Name");
		user.setLastName("Last Name");
		user.setEmail("coolnimesh43@gmail.com");
		user.setPassword("nimesh");
		return user;
	}

	private Group getGroup() {
		Group group = new Group("WhiteBeard Pirates");
		return group;
	}

	private List<Mood> getMoods() {
		List<Mood> moods = new ArrayList<>();
		Mood m1 = new Mood("Relaxed");
		Mood m2 = new Mood("Happy");
		Mood m3 = new Mood("Sad");
		Mood m4 = new Mood("Angry");
		moods.add(m1);
		moods.add(m2);
		moods.add(m3);
		moods.add(m4);
		return moods;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		LOG.debug("Bootstrap#creating user");
		if (this.userService.getAll().isEmpty() && this.groupService.getAll().isEmpty()) {
			List<Group> groups = new ArrayList<>();
			User usr = getUsers();
			Group g = getGroup();
			Group g1 = new Group("Black Beard Pirates");
			groups.add(g);
			groups.add(g1);
			usr.setGroups(groups);
			usr = this.userService.save(usr);

		}
		if (this.moodService.getAll().isEmpty()) {
			for (Mood m : getMoods()) {
				this.moodService.save(m);
			}
		}
	}

}
