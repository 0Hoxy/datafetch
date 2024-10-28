package com.hoxy.datafetch.entity.user;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Company {
    private String name;
    private String catchPhrase;
    private String bs;
}
