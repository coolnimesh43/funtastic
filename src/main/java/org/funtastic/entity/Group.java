package org.funtastic.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "app_group")
public class Group extends AbstractEntity {

	@Column(name = "name", nullable = false)
	private String name;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "groups")
	@JsonManagedReference
	private List<User> groupUsers = new ArrayList<>();

	public Group() {
		super();
	}

	public Group(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getGroupUsers() {
		return groupUsers;
	}

	public void setGroupUsers(List<User> groupUsers) {
		this.groupUsers = groupUsers;
	}

	@Override
	public String toString() {
		return "Group [name=" + name + "]";
	}

}
