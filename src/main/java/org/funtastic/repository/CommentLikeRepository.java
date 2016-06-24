package org.funtastic.repository;

import java.util.List;

import org.funtastic.entity.CommentLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentLikeRepository extends JpaRepository<CommentLike, Long> {

	@Query("select c from CommentLike c where c.likedBy.id=?1")
	List<CommentLike> findAllByUser(Long userId);

	@Query("select c from CommentLike c where c.comment.id=?1")
	List<CommentLike> findAllByComment(Long commentId);
}
