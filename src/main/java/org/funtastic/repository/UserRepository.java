package org.funtastic.repository;

import org.funtastic.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Long, User>{

	@Query("select u from User u where u.email=?1")
	public User findByEmail(String email);
}
