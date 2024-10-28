package com.hoxy.datafetch.Controller;

import com.hoxy.datafetch.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/fetch/{id}")
    public Mono<Void> fetchAndSaveUser(@PathVariable String id) {
        return userService.fetchAndSaveUser(id);
    }

    @GetMapping("/fetch")
    public Mono<Void> fetchAndSaveUsers() {
        return userService.fetchAndSaveUsers();
    }
}
