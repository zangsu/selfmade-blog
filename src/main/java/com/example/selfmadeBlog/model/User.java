package com.example.selfmadeBlog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {

    int idx;
    String id;
    String password;

    public User(String id, String password) {
        this.id = id;
        this.password = password;
    }
}
