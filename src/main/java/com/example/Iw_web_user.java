package com.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;


@Entity
@Table(name = "iw_web_user")
public class Iw_web_user {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "web_user")
    private Long web_user;

    public String name;
    
    public String email;


    public Iw_web_user() {

    }

    public Iw_web_user(String name) {
        this.name = name;
    }

    public Long getId() {
        return web_user;
    }

    public void setId(Long web_user) {
        this.web_user = web_user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name: " + name + ".\n" 
            + "With Id: " + web_user;
    }
}
