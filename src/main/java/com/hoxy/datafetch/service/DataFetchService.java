package com.hoxy.datafetch.service;

import com.hoxy.datafetch.entity.album.Album;
import com.hoxy.datafetch.entity.comment.Comment;
import com.hoxy.datafetch.entity.photo.Photo;
import com.hoxy.datafetch.entity.post.Post;
import com.hoxy.datafetch.entity.todo.Todo;
import com.hoxy.datafetch.entity.user.User;
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

    public Flux<Post> getPosts() {
        return webClient.get()
                .uri("/posts")
                .retrieve()
                .bodyToFlux(Post.class);
    }

    public Mono<Post> getPost(String id) {
        return webClient.get()
                .uri("/posts/{id}", id) //{id} 경로 변수에 id 값을 바인딩
                .retrieve()
                .bodyToMono(Post.class);
    }

    public Flux<Todo> getTodos() {
        return webClient.get()
                .uri("/todos")
                .retrieve()
                .bodyToFlux(Todo.class);
    }

    public Mono<Todo> getTodo(String id) {
        return webClient.get()
                .uri("/todos/{id}", id)
                .retrieve()
                .bodyToMono(Todo.class);
    }

    public Flux<Photo> getPhotos() {
        return webClient.get()
                .uri("/photos")
                .retrieve()
                .bodyToFlux(Photo.class);
    }

    public Mono<Photo> getPhoto(String id) {
        return webClient.get()
                .uri("/photos/{id}", id)
                .retrieve()
                .bodyToMono(Photo.class);
    }

    public Flux<Comment> getComments() {
        return webClient.get()
                .uri("/comments")
                .retrieve()
                .bodyToFlux(Comment.class);
    }

    public Mono<Comment> getComment(String id) {
        return webClient.get()
                .uri("/comments/{id}",id)
                .retrieve()
                .bodyToMono(Comment.class);
    }

    public Flux<Album> getAlbums() {
        return webClient.get()
                .uri("/albums")
                .retrieve()
                .bodyToFlux(Album.class);
    }

    public Mono<Album> getAlbum(String id) {
        return webClient.get()
                .uri("/albums/{id}",id)
                .retrieve()
                .bodyToMono(Album.class);
    }

    public Flux<User> getUsers() {
        return webClient.get()
                .uri("/users")
                .retrieve()
                .bodyToFlux(User.class);
    }

    public Mono<User> getUser(String id) {
        return webClient.get()
                .uri("/users/{id}", id)
                .retrieve()
                .bodyToMono(User.class);
    }

}
