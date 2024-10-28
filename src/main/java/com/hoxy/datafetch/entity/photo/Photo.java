package com.hoxy.datafetch.entity.photo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Photo {
    @Id
    private Long id;

    private String title;
    private String url;
    private String thumbnailUrl;
}
