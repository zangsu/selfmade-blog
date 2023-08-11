package com.example.selfmadeBlog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Posting {
    int idx;

    public Posting(String title, int user_idx, String content) {
        this.title = title;
        this.user_idx = user_idx;
        this.content = content;
    }

    String title;
    int user_idx;
    String content;
}
