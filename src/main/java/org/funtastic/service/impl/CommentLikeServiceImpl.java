package org.funtastic.service.impl;

import java.util.List;

import org.funtastic.entity.CommentLike;
import org.funtastic.repository.CommentLikeRepository;
import org.funtastic.service.CommentLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CommentLikeServiceImpl implements CommentLikeService {

	@Autowired
	private CommentLikeRepository commentLikeRepository;

	@Override
	public CommentLike findById(Long id) {
		return this.commentLikeRepository.findOne(id);
	}

	@Override
	public List<CommentLike> getAll() {
		return this.commentLikeRepository.findAll();
	}

	@Override
	@Transactional
	public CommentLike save(CommentLike r) {
		return this.commentLikeRepository.save(r);
	}

	@Override
	@Transactional
	public void delete(CommentLike r) {
		this.commentLikeRepository.delete(r);
	}

	@Override
	public List<CommentLike> findAllByUser(Long userId) {
		return this.commentLikeRepository.findAllByUser(userId);
	}

	@Override
	public List<CommentLike> findAllByComment(Long commentId) {
		return this.commentLikeRepository.findAllByComment(commentId);
	}

}
