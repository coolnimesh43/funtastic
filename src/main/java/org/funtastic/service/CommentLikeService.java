package org.funtastic.service;

import java.util.List;

import org.funtastic.entity.CommentLike;

public interface CommentLikeService extends GenericService<Long, CommentLike> {

	List<CommentLike> findAllByUser(Long userId);

	List<CommentLike> findAllByComment(Long commentId);
}
