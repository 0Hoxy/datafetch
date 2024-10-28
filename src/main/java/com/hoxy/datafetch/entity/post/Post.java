package com.hoxy.datafetch.entity.post;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Post {
    @Id
    private Long id;

    private String title;
    private String body;

    private Long userId;
}
