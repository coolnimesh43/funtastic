package org.funtastic.service;

import org.funtastic.entity.User;
import org.funtastic.pojo.UserDTO;

public interface UserService extends GenericService<Long, User> {

	User findByEmail(String email);

	Boolean validateUser(UserDTO userDTO);

	User create(UserDTO userDTO);
}
