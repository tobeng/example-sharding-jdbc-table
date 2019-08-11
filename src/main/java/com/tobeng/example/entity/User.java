package com.tobeng.example.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id")
    protected Long id;

    @Column(name = "city")
    private String city;

    @Column(name = "name")
    private String name;
}
