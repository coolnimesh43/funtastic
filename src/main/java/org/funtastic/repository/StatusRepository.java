package org.funtastic.repository;

import java.util.List;

import org.funtastic.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status,Long>{

	@Query("select s from Status s where s.statusBy.id=?1")
	public List<Status> findAllByUser(Long userId);
	
	@Query("select s from Status s where s.statusBy.id=?1 and s.mood.id=?2")
	public List<Status> findAllByUserAndMood(Long userId, Long moodId);
}
