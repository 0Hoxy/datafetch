package com.hoxy.datafetch.entity.todo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Todo {
    @Id
    private Long id;

    private String title;
    private boolean completed;

    private Long userId;
}
