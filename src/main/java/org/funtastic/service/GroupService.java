package org.funtastic.service;

import java.util.List;

import org.funtastic.entity.Group;

public interface GroupService extends GenericService<Long, Group>{

	List<Group> findByName(String name);
}
