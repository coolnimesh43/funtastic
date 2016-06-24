package org.funtastic.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="status_like")
public class StatusLike extends AbstractEntity {

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="status")
	private Status status;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="liked_by")
	private User likedBy;

	public StatusLike() {
		super();
	}

	public StatusLike(Status status, User likedBy) {
		super();
		this.status = status;
		this.likedBy = likedBy;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public User getLikedBy() {
		return likedBy;
	}

	public void setLikedBy(User likedBy) {
		this.likedBy = likedBy;
	}

	@Override
	public String toString() {
		return "StatusLike [status=" + status + ", likedBy=" + likedBy + "]";
	}
	
	
}
