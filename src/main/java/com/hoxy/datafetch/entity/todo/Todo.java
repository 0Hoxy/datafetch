package com.hoxy.datafetch.entity.todo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Todo {
    @Id
    private Long id;

    private String title;
    private boolean completed;

    private Long userId;
}
