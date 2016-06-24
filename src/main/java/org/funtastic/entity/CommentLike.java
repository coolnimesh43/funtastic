package org.funtastic.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="comment_like")
public class CommentLike extends AbstractEntity {

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="comment")
	private Comment comment;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="liked_by")
	private User likedBy;

	public CommentLike() {
		super();
	}

	public CommentLike(Comment comment, User likedBy) {
		super();
		this.comment = comment;
		this.likedBy = likedBy;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public User getLikedBy() {
		return likedBy;
	}

	public void setLikedBy(User likedBy) {
		this.likedBy = likedBy;
	}

	@Override
	public String toString() {
		return "CommentLike [comment=" + comment + ", likedBy=" + likedBy + "]";
	}
	
	
}
