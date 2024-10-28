package com.hoxy.datafetch.repository;

import com.hoxy.datafetch.entity.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
