package com.hoxy.datafetch.Controller;

import com.hoxy.datafetch.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/fetch/{id}")
    public Mono<Void> fetchAndSaveComment(@PathVariable String id) {
        return commentService.fetchAndSaveComment(id);
    }

    @GetMapping("/fetch")
    public Mono<Void> fetchAndSaveComments() {
        return commentService.fetchAndSaveComments();
    }
}
