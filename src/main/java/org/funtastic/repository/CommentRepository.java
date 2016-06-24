package org.funtastic.repository;

import java.util.List;

import org.funtastic.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

	List<Comment> findByDescription(String description);

	@Query("select c from Comment c where c.status.id=?1")
	List<Comment> findAllByStatus(Long statusId);

}
