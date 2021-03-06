package org.funtastic.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.funtastic.enums.CommentType;
import org.funtastic.utility.TimeAgo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "comment")
public class Comment extends AbstractEntity {

	@Column(name = "description", nullable = false)
	@NotNull
	private String description;

	@Enumerated(EnumType.STRING)
	@Column(name = "comment_type", nullable = false)
	private CommentType commentType;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "comment_by")
	private User commentBy;

	@ManyToOne
	@JoinColumn(name = "status_id")
	@JsonManagedReference
	private Status status;

	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@OrderBy("createdDate ASC")
	@JsonBackReference
	List<CommentLike> commentLikes;

	@Transient
	String timeAgo;

	public String getTimeAgo() {
		return TimeAgo.toDuration(this.getCreatedDate().getTime());
	}

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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<CommentLike> getCommentLikes() {
		return commentLikes;
	}

	public void setCommentLikes(List<CommentLike> commentLikes) {
		this.commentLikes = commentLikes;
	}

	@Override
	public String toString() {
		return "Comment [description=" + description + ", commentType=" + commentType + ", commentBy=" + commentBy
				+ "]";
	}

}
