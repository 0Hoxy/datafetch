package com.hoxy.datafetch.service;

import com.hoxy.datafetch.repository.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final DataFetchService dataFetchService;

    public UserService(UserRepository userRepository, DataFetchService dataFetchService) {
        this.userRepository = userRepository;
        this.dataFetchService = dataFetchService;
    }

    public Mono<Void> fetchAndSaveUser(String id) {
        return dataFetchService.getUser(id)
                .publishOn(Schedulers.boundedElastic())
                .flatMap(user -> {
                    userRepository.save(user);
                    return Mono.empty();
                });
    }

    public Mono<Void> fetchAndSaveUsers() {
        return dataFetchService.getUsers()  // Flux<User>로 여러 사용자 데이터를 가져옴
                .publishOn(Schedulers.boundedElastic())
                .flatMap(user -> Mono.fromCallable(() -> {
                    userRepository.save(user);  // 각 User 객체를 저장
                    return null;
                }))
                .then();  // 완료 신호 반환
    }

}

