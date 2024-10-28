package com.hoxy.datafetch.entity.photo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Photo {
    @Id
    private Long id;

    private String title;
    private String url;
    private String thumbnailUrl;
}
