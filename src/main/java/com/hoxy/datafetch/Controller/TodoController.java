package com.hoxy.datafetch.Controller;

import com.hoxy.datafetch.service.TodoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/fetch/{id}")
    public Mono<Void> fetchAndSaveTodo(@PathVariable String id) {
        return todoService.fetchAndSaveTodo(id);
    }

    @GetMapping("/fetch")
    public Mono<Void> fetchAndSaveTodos() {
        return todoService.fetchAndSaveTodos();
    }


}
