package com.hoxy.datafetch.entity.user;

import jakarta.persistence.*;

@Entity
public class User {

    @Id
    private Long id;

    private String name;
    private String username;
    private String email;
    private String phone;
    private String website;

    @Embedded
    private Address address;

    @Embedded
    @AttributeOverride(name = "name", column = @Column(name = "company_name"))
    private Company company;

}
