package com.hoxy.datafetch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DataFetchService {

    private final WebClient webClient;

    @Autowired
    public DataFetchService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Flux<String> getPosts() {
        return webClient.get()
                .uri("/posts")
                .retrieve()
                .bodyToFlux(String.class);
    }

    public Mono<String> getPost(String id) {
        return webClient.get()
                .uri("/posts/{id}", id) //{id} 경로 변수에 id 값을 바인딩
                .retrieve()
                .bodyToMono(String.class);
    }

    public Flux<String> getTodos() {
        return webClient.get()
                .uri("/todos")
                .retrieve()
                .bodyToFlux(String.class);
    }

    public Mono<String> getTodo(String id) {
        return webClient.get()
                .uri("/todos/{id}", id)
                .retrieve()
                .bodyToMono(String.class);
    }

    public Flux<String> getPhotos() {
        return webClient.get()
                .uri("/photos")
                .retrieve()
                .bodyToFlux(String.class);
    }

    public Mono<String> getPhoto(String id) {
        return webClient.get()
                .uri("/photos/{id}", id)
                .retrieve()
                .bodyToMono(String.class);
    }

    public Flux<String> getComments() {
        return webClient.get()
                .uri("/comments")
                .retrieve()
                .bodyToFlux(String.class);
    }

    public Mono<String> getComment(String id) {
        return webClient.get()
                .uri("/comments/{id}",id)
                .retrieve()
                .bodyToMono(String.class);
    }

    public Flux<String> getAlbums() {
        return webClient.get()
                .uri("/albums")
                .retrieve()
                .bodyToFlux(String.class);
    }

    public Mono<String> getAlbum(String id) {
        return webClient.get()
                .uri("/albums/{id}",id)
                .retrieve()
                .bodyToMono(String.class);
    }

    public Flux<String> getUsers() {
        return webClient.get()
                .uri("/users")
                .retrieve()
                .bodyToFlux(String.class);
    }

    public Mono<String> getUser(String id) {
        return webClient.get()
                .uri("/users/{id}", id)
                .retrieve()
                .bodyToMono(String.class);
    }

}
