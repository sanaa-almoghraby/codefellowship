package com.example.codefellowship.Models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String body;
    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne
    public ApplicationUser user;

    public Post(){

    }

    public Post(String body , ApplicationUser user) {
        this.body = body;
        this.user = user;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public int getId() {
        return id;
    }

    public ApplicationUser getUser() {
        return user;
    }

    public void setUser(ApplicationUser user) {
        this.user = user;
    }
}
