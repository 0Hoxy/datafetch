package com.hoxy.datafetch.entity.comment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Comment {
    @Id
    private Long id;

    private String name;
    private String email;

    @Column(length = 1000) // 최대 길이를 500으로 설정(기본 길이의 한계 때문에 오류가 있었음)
    private String body;

    private Long postId;
}
