package com.hoxy.datafetch.entity.album;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Album {
    @Id
    private Long id;

    private String title;

    private Long userId;
}
