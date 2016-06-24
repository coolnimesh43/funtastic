package org.funtastic.service;

import java.util.List;

import org.funtastic.entity.StatusLike;

public interface StatusLikeService extends GenericService<Long, StatusLike> {

	List<StatusLike> findAllByUser(Long userId);
	List<StatusLike> findAllByStatus(Long statusId);
}
