package com.example.selfmadeBlog.dto;

import com.example.selfmadeBlog.model.Posting;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostingDTO {

    int idx;
    String title;
    int user_idx;
    String content;

    public PostingDTO(String title, int user_idx, String content) {
        this.title = title;
        this.user_idx = user_idx;
        this.content = content;
    }

    public Posting getPostingObj(){
        return new Posting(this.title, this.user_idx, this.content);
    }


}
