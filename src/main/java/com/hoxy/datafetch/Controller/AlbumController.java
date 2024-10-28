package com.hoxy.datafetch.Controller;

import com.hoxy.datafetch.service.AlbumService;
import com.hoxy.datafetch.service.PhotoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/albums")
public class AlbumController {

    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping("/fetch/{id}")
    public Mono<Void> fetchAndSaveAlbum(@PathVariable String id) {
        return albumService.fetchAndSaveAlbum(id);
    }

    @GetMapping("/fetch")
    public Mono<Void> fetchAndSaveAlbums() {
        return albumService.fetchAndSaveAlbums();
    }
}
