package org.funtastic.service;

import java.util.List;

import org.funtastic.entity.Comment;

public interface CommentService extends GenericService<Long, Comment> {

	List<Comment> findByDescription(String description);

	List<Comment> findAllByStatus(Long statusId);

	List<Comment> findAllByUser(Long userId);

	List<Comment> findAllByCommentType(String commentType);
}
