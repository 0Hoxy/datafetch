package com.hoxy.datafetch.service;

import com.hoxy.datafetch.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final DataFetchService dataFetchService;

    @Autowired
    public CommentService(CommentRepository commentRepository, DataFetchService dataFetchService) {
        this.commentRepository = commentRepository;
        this.dataFetchService = dataFetchService;
    }

    public Mono<Void> fetchAndSaveComment(String id) {
        return dataFetchService.getComment(id)
                .publishOn(Schedulers.boundedElastic())
                .flatMap(comment -> {
                    commentRepository.save(comment);
                    return Mono.empty();
                });
    }

    public Mono<Void> fetchAndSaveComments() {
        return dataFetchService.getComments()
                .publishOn(Schedulers.boundedElastic())
                .flatMap(comments -> Mono.fromCallable(() ->{
                    commentRepository.save(comments); // 비동기 저장 작업
                    return Mono.empty(); // 빈 Mono<Void> 반환
                }))
                .then();
    }

}
