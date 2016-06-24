package org.funtastic.service.impl;

import java.util.List;

import org.funtastic.entity.Comment;
import org.funtastic.repository.CommentRepository;
import org.funtastic.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepository;

	@Override
	public Comment findById(Long id) {
		return this.commentRepository.findOne(id);
	}

	@Override
	public List<Comment> getAll() {
		return this.commentRepository.findAll();
	}

	@Override
	@Transactional
	public Comment save(Comment r) {
		return this.commentRepository.save(r);
	}

	@Override
	@Transactional
	public void delete(Comment r) {
		this.commentRepository.delete(r);
	}

	@Override
	public List<Comment> findByDescription(String description) {
		return this.findByDescription(description);
	}

	@Override
	public List<Comment> findAllByStatus(Long statusId) {
		return this.findAllByStatus(statusId);
	}

	@Override
	public List<Comment> findAllByUser(Long userId) {
		return this.commentRepository.findAllByUser(userId);
	}

	@Override
	public List<Comment> findAllByCommentType(String commentType) {
		return this.findAllByCommentType(commentType);
	}

}
