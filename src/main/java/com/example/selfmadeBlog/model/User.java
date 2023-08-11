package com.example.selfmadeBlog.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class User {

    int idx;
    String id;
    String password;

    public User(String id, String password) {
        this.id = id;
        this.password = password;
    }
}
