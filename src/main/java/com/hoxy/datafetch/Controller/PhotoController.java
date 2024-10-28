package com.hoxy.datafetch.Controller;

import com.hoxy.datafetch.service.PhotoService;
import com.hoxy.datafetch.service.TodoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/photos")
public class PhotoController {

    private final PhotoService photoService;

    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping("/fetch/{id}")
    public Mono<Void> fetchAndSavePhoto(@PathVariable String id) {
        return photoService.fetchAndSavePhoto(id);
    }

    @GetMapping("/fetch")
    public Mono<Void> fetchAndSavePhotos() {
        return photoService.fetchAndSavePhotos();
    }
}
