package org.funtastic.config;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.funtastic.entity.Group;
import org.funtastic.entity.Image;
import org.funtastic.entity.Mood;
import org.funtastic.entity.User;
import org.funtastic.enums.Gender;
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

	List<User> users = new ArrayList<>();

	private void getUsers() {
		User user = new User("Nimesh", "Mishra", "coolnimesh43@gmail.com", "nimesh");
		user.setGenderType(Gender.MALE);
		Image i1 = new Image();
		i1.setUrl("http://orig11.deviantart.net/6a48/f/2015/109/6/b/profile_picture_by_the_meme_king-d8qbvjp.png");
		user.setProfiePic(i1);
		users.add(user);

		User u2 = new User("Pawal", "Adhikari", "adhpawal@lftechnology.com", "pawal");
		u2.setGenderType(Gender.MALE);
		Image i2 = new Image();
		i2.setUrl("http://i1.kym-cdn.com/profiles/icons/big/000/132/880/awesome%20face%20shrug.jpg");
		u2.setProfiePic(i2);
		users.add(u2);
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
			getUsers();
			List<Group> groups = new ArrayList<>();
			User usr = this.users.get(0);
			Group g = getGroup();
			Group g1 = new Group("Black Beard Pirates");
			groups.add(g);
			groups.add(g1);
			usr.setGroups(groups);
			usr = this.userService.save(usr);

			User u2 = this.users.get(1);
			Group g3 = new Group("War Zone");
			Group g4 = new Group("FriendZone");

			groups = new ArrayList<>();
			groups.add(g3);
			groups.add(g4);

			u2.setGroups(groups);
			this.userService.save(u2);
		}
		if (this.moodService.getAll().isEmpty()) {
			for (Mood m : getMoods()) {
				this.moodService.save(m);
			}
		}
	}

}
