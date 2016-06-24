package org.funtastic.service;

import org.funtastic.entity.User;

public interface UserService extends GenericService<Long, User>{

	public User findByEmail(String email);
}
