package org.funtastic.service;

import java.util.List;

import org.funtastic.entity.Status;

public interface StatusService extends GenericService<Long, Status> {

	List<Status> findAllByUser(Long userId);
	List<Status> findAllByUserAndMood(Long userId, Long moodId);
}
