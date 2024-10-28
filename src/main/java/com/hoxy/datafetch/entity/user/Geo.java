package com.hoxy.datafetch.entity.user;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter @Setter
public class Geo {
    private Double lat;
    private Double lng;
}
