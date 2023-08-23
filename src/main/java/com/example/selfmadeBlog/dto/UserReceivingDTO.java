package com.example.selfmadeBlog.dto;

import com.example.selfmadeBlog.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserReceivingDTO {

    int idx;
    String id;
    String password;

    public UserReceivingDTO(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public User getUserObj(){
        return new User(this.id, this.password);
    }
}
