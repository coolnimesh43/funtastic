package org.funtastic.config;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.funtastic.entity.Group;
import org.funtastic.entity.User;
import org.funtastic.enums.Gender;
import org.funtastic.service.GroupService;
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

    private User getUsers() {
        User user = new User();
        user.setFirstName("First Name");
        user.setLastName("Last Name");
        user.setEmail("coolnimesh43@gmail.com");
        user.setPassword("nimesh");
        user.setGenderType(Gender.MALE);
        return user;
    }

    private Group getGroup() {
        Group group = new Group("WhiteBeard Pirates");
        return group;
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
    }

}
