package com.hoxy.datafetch.entity.user;

import jakarta.persistence.Embeddable;

@Embeddable
public class Company {
    private String name;
    private String catchPhrase;
    private String bs;
}
