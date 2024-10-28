package com.hoxy.datafetch.entity.user;

import jakarta.persistence.Embeddable;

@Embeddable
public class Geo {
    private Double lat;
    private Double lng;
}
