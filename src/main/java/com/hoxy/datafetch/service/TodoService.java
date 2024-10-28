package com.hoxy.datafetch.service;

import com.hoxy.datafetch.repository.TodoRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
public class TodoService {

    private final TodoRepository todoRepository;
    private final DataFetchService dataFetchService;

    public TodoService(TodoRepository todoRepository, DataFetchService dataFetchService) {
        this.todoRepository = todoRepository;
        this.dataFetchService = dataFetchService;
    }

    public Mono<Void> fetchAndSaveTodo(String id) {
        return dataFetchService.getTodo(id)
                .publishOn(Schedulers.boundedElastic())
                .flatMap(todo -> {
                    todoRepository.save(todo);
                    return Mono.empty();
                });
    }

    public Mono<Void> fetchAndSaveTodos() {
        return dataFetchService.getTodos()
                .publishOn(Schedulers.boundedElastic())
                .flatMap(todos -> Mono.fromCallable(() -> {
                    todoRepository.save(todos);
                    return Mono.empty();
                }))
                .then();
    }

}
