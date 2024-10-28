package com.hoxy.datafetch.Controller;

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
    public ResponseEntity<Flux<String>> getPosts() {
        Flux<String> posts = dataFetchService.getPosts();
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Mono<String>> getPost(@PathVariable String id) {
        Mono<String> post = dataFetchService.getPost(id);
        return ResponseEntity.ok(post);

    }

    @GetMapping("/comments")
    public ResponseEntity<Flux<String>> getComments() {
        Flux<String> comments = dataFetchService.getComments();
        return ResponseEntity.ok(comments);
    }

    @GetMapping("/comments/{id}")
    public ResponseEntity<Mono<String>> getComment(@PathVariable String id) {
        Mono<String> comment = dataFetchService.getComment(id);
        return ResponseEntity.ok(comment);
    }

    @GetMapping("/albums")
    public ResponseEntity<Flux<String>> getAlbums() {
        Flux<String> albums = dataFetchService.getAlbums();
        return ResponseEntity.ok(albums);
    }

    @GetMapping("/albums/{id}")
    public ResponseEntity<Mono<String>> getAlbum(@PathVariable String id) {
        Mono<String> album = dataFetchService.getAlbum(id);
        return ResponseEntity.ok(album);
    }

    @GetMapping("/photos")
    public ResponseEntity<Flux<String>> getPhotos() {
        Flux<String> photos = dataFetchService.getPhotos();
        return ResponseEntity.ok(photos);
    }

    @GetMapping("/photos/{id}")
    public ResponseEntity<Mono<String>> getPhoto(@PathVariable String id) {
        Mono<String> photo = dataFetchService.getPhoto(id);
        return ResponseEntity.ok(photo);
    }

    @GetMapping("/todos")
    public ResponseEntity<Flux<String>> getTodos() {
        Flux<String> todos = dataFetchService.getTodos();
        return ResponseEntity.ok(todos);
    }

    @GetMapping("/todos/{id}")
    public ResponseEntity<Mono<String>> getTodo(@PathVariable String id) {
        Mono<String> todo = dataFetchService.getTodo(id);
        return ResponseEntity.ok(todo);
    }

    @GetMapping("/users")
    public ResponseEntity<Flux<String>> getUsers() {
        Flux<String> users = dataFetchService.getUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Mono<String>> getUser(@PathVariable String id) {
        Mono<String> user = dataFetchService.getUser(id);
        return ResponseEntity.ok(user);
    }

}
