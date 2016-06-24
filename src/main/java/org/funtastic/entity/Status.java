package org.funtastic.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "status")
public class Status extends AbstractEntity {

	@Column(name = "description")
	private String description;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mood")
	private Mood mood;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "status_by")
	private User statusBy;

	@Column(name = "state", nullable = false)
	@NotNull
	private Boolean state;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@OrderBy("updatedDate ASC")
	private List<Comment> comments;

	public Status() {
		super();
	}

	public Status(String description, Mood mood, User status_by, Boolean state) {
		super();
		this.description = description;
		this.mood = mood;
		this.statusBy = status_by;
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

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public User getStatusBy() {
		return statusBy;
	}

	public void setStatusBy(User statusBy) {
		this.statusBy = statusBy;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Status [description=" + description + ", mood=" + mood + ", status_by=" + statusBy + ", state=" + state
				+ "]";
	}

}
