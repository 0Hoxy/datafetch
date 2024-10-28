package com.hoxy.datafetch.service;

import com.hoxy.datafetch.entity.post.Post;
import com.hoxy.datafetch.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final DataFetchService dataFetchService;

    @Autowired
    public PostService(PostRepository postRepository, DataFetchService dataFetchService) {
        this.postRepository = postRepository;
        this.dataFetchService = dataFetchService;
    }

    public Mono<Void> fetchAndSavePost(String id) {
        return dataFetchService.getPost(id)
                .publishOn(Schedulers.boundedElastic())  // 블로킹 작업을 별도의 스레드에서 실행
                .flatMap(post -> {
                    postRepository.save(post);  // JPA로 데이터를 저장
                    return Mono.empty();  // 저장된 Post 객체 반환
                });
    }

    public Mono<Void> fetchAndSavePosts() {
        return dataFetchService.getPosts()
                .publishOn(Schedulers.boundedElastic())
                .flatMap(posts -> Mono.fromCallable(() -> {
                    postRepository.save(posts);
                    return Mono.empty();
                }))
                .then();
    }
}

