package com.hoxy.datafetch.service;

import com.hoxy.datafetch.repository.AlbumRepository;
import com.hoxy.datafetch.repository.PhotoRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
public class AlbumService {

    private final AlbumRepository albumRepository;
    private final DataFetchService dataFetchService;

    public AlbumService(AlbumRepository albumRepository, DataFetchService dataFetchService) {
        this.albumRepository = albumRepository;
        this.dataFetchService = dataFetchService;
    }

    public Mono<Void> fetchAndSaveAlbum(String id) {
        return dataFetchService.getAlbum(id)
                .publishOn(Schedulers.boundedElastic())
                .flatMap(album -> {
                    albumRepository.save(album);
                    return Mono.empty();
                });
    }

    public Mono<Void> fetchAndSaveAlbums() {
        return dataFetchService.getAlbums()
                .publishOn(Schedulers.boundedElastic())
                .flatMap(albums -> Mono.fromCallable(() ->{
                    albumRepository.save(albums);
                    return Mono.empty();
                }))
                .then();
    }
}
