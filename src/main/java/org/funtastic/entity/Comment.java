package org.funtastic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.funtastic.enums.CommentType;

@Entity
@Table(name = "comment")
public class Comment extends AbstractEntity {
	
	@Column(name = "description", nullable = false)
	@NotNull
	private String description;

	@Enumerated(EnumType.STRING)
	@Column(name="comment_type",nullable=false)
	private CommentType commentType;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="comment_by")
	private User commentBy;

	public Comment() {
		super();
	}

	public Comment(String description, CommentType commentType, User commentBy) {
		super();
		this.description = description;
		this.commentType = commentType;
		this.commentBy = commentBy;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CommentType getCommentType() {
		return commentType;
	}

	public void setCommentType(CommentType commentType) {
		this.commentType = commentType;
	}

	public User getCommentBy() {
		return commentBy;
	}

	public void setCommentBy(User commentBy) {
		this.commentBy = commentBy;
	}

	@Override
	public String toString() {
		return "Comment [description=" + description + ", commentType=" + commentType + ", commentBy=" + commentBy
				+ "]";
	}
	
	
}
