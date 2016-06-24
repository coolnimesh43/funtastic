package org.funtastic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="status")
public class Status extends AbstractEntity{

	@Column(name="description")
	private String description;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="mood")
	private Mood mood;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="status_by")
	private User status_by;
	
	@Column(name="state",nullable=false)
	@NotNull
	private Boolean state;

	public Status() {
		super();
	}

	public Status(String description, Mood mood, User status_by, Boolean state) {
		super();
		this.description = description;
		this.mood = mood;
		this.status_by = status_by;
		this.state = state;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Mood getMood() {
		return mood;
	}

	public void setMood(Mood mood) {
		this.mood = mood;
	}

	public User getStatus_by() {
		return status_by;
	}

	public void setStatus_by(User status_by) {
		this.status_by = status_by;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Status [description=" + description + ", mood=" + mood + ", status_by=" + status_by + ", state=" + state
				+ "]";
	}
	
	
}
