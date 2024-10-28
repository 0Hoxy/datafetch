package com.hoxy.datafetch.repository;

import com.hoxy.datafetch.entity.todo.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
