package com.hoxy.datafetch.Controller;

import com.hoxy.datafetch.entity.album.Album;
import com.hoxy.datafetch.entity.comment.Comment;
import com.hoxy.datafetch.entity.photo.Photo;
import com.hoxy.datafetch.entity.post.Post;
import com.hoxy.datafetch.entity.todo.Todo;
import com.hoxy.datafetch.entity.user.User;
import com.hoxy.datafetch.service.DataFetchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/data")
public class DataFetchController {

    private final DataFetchService dataFetchService;

    @Autowired
    public DataFetchController(DataFetchService dataFetchService) {
        this.dataFetchService = dataFetchService;
    }

    @GetMapping("/posts")
    public Flux<Post> getPosts() {
        return dataFetchService.getPosts();  // Flux<Post> 반환
    }

    @GetMapping("/posts/{id}")
    public Mono<Post> getPost(@PathVariable String id) {
        return dataFetchService.getPost(id);  // Mono<Post> 반환
    }

    @GetMapping("/comments")
    public Flux<Comment> getComments() {
        return dataFetchService.getComments();  // Flux<String> 반환
    }

    @GetMapping("/comments/{id}")
    public Mono<Comment> getComment(@PathVariable String id) {
        return dataFetchService.getComment(id);  // Mono<String> 반환
    }

    @GetMapping("/albums")
    public Flux<Album> getAlbums() {
        return dataFetchService.getAlbums();  // Flux<String> 반환
    }

    @GetMapping("/albums/{id}")
    public Mono<Album> getAlbum(@PathVariable String id) {
        return dataFetchService.getAlbum(id);  // Mono<String> 반환
    }

    @GetMapping("/photos")
    public Flux<Photo> getPhotos() {
        return dataFetchService.getPhotos();  // Flux<String> 반환
    }

    @GetMapping("/photos/{id}")
    public Mono<Photo> getPhoto(@PathVariable String id) {
        return dataFetchService.getPhoto(id);  // Mono<String> 반환
    }

    @GetMapping("/todos")
    public Flux<Todo> getTodos() {
        return dataFetchService.getTodos();  // Flux<String> 반환
    }

    @GetMapping("/todos/{id}")
    public Mono<Todo> getTodo(@PathVariable String id) {
        return dataFetchService.getTodo(id);  // Mono<String> 반환
    }

    @GetMapping("/users")
    public Flux<User> getUsers() {
        return dataFetchService.getUsers();  // Flux<String> 반환
    }

    @GetMapping("/users/{id}")
    public Mono<User> getUser(@PathVariable String id) {
        return dataFetchService.getUser(id);  // Mono<String> 반환
    }
}

