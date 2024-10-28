package com.hoxy.datafetch.entity.album;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Album {
    @Id
    private Long id;

    private String title;

    private Long userId;
}
