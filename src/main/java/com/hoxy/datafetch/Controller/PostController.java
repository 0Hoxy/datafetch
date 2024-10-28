package com.hoxy.datafetch.Controller;

import com.hoxy.datafetch.entity.post.Post;
import com.hoxy.datafetch.repository.PostRepository;
import com.hoxy.datafetch.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {

        this.postService = postService;
    }

    @GetMapping("/fetch/{id}")
    public Mono<Void> fetchAndSavePost(@PathVariable String id) {
        return postService.fetchAndSavePost(id);
    }

    @GetMapping("/fetch")
    public Mono<Void> fetchAndSavePosts() {
        return postService.fetchAndSavePosts();
    }
}
