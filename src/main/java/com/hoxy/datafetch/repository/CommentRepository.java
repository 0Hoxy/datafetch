package com.hoxy.datafetch.repository;

import com.hoxy.datafetch.entity.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
