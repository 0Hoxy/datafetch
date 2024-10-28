package com.hoxy.datafetch.Controller;

import com.hoxy.datafetch.service.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/fetch/all")
public class AllSaveController {

    private final UserService userService;
    private final PostService postService;
    private final TodoService todoService;
    private final PhotoService photoService;
    private final CommentService commentService;
    private final AlbumService albumService;

    @Transactional
    @GetMapping
    public Mono<Void> saveAll() {
        return Flux.concat(
                userService.fetchAndSaveUsers(),
                postService.fetchAndSavePosts(),
                todoService.fetchAndSaveTodos(),
                photoService.fetchAndSavePhotos(),
                commentService.fetchAndSaveComments(),
                albumService.fetchAndSaveAlbums()
        ).then();
    }
}
