package com.hoxy.datafetch.service;

import com.hoxy.datafetch.repository.PhotoRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import javax.xml.crypto.Data;

@Service
public class PhotoService {

    private final PhotoRepository photoRepository;
    private final DataFetchService dataFetchService;

    public PhotoService(PhotoRepository photoRepository, DataFetchService dataFetchService) {
        this.photoRepository = photoRepository;
        this.dataFetchService = dataFetchService;
    }

    public Mono<Void> fetchAndSavePhoto(String id) {
        return dataFetchService.getPhoto(id)
                .publishOn(Schedulers.boundedElastic())
                .flatMap(photo -> {
                    photoRepository.save(photo);
                    return Mono.empty();
                });
    }

    public Mono<Void> fetchAndSavePhotos() {
        return dataFetchService.getPhotos()
                .publishOn(Schedulers.boundedElastic())
                .flatMap(photos -> Mono.fromCallable(() ->{
                    photoRepository.save(photos);
                    return Mono.empty();
                }))
                .then();
    }
}
