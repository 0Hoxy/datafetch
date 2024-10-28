package com.hoxy.datafetch.entity.comment;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Comment {
    @Id
    private Long id;

    private String name;
    private String email;
    private String body;

    private Long postId;
}
