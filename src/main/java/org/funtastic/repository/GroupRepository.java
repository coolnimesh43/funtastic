package org.funtastic.repository;

import java.util.List;

import org.funtastic.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group,Long>{

	List<Group>findByName(String name);
}
