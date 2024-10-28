package com.hoxy.datafetch.entity.post;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Post {
    @Id
    private Long id;

    private String title;
    private String body;

    private Long userId;
}
