package org.funtastic.repository;

import java.util.List;

import org.funtastic.entity.StatusLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusLikeRepository extends JpaRepository<StatusLike,Long>{

	@Query("select s from StatusLike s where s.likedBy.id=?1")
	List<StatusLike> findAllByUser(Long userId);
	
	@Query("select s from StatusLike s where s.status.id=?1")
	List<StatusLike> findAllByStatus(Long statusId);
}
