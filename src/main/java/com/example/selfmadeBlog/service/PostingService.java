package com.example.selfmadeBlog.service;

import com.example.selfmadeBlog.DAO.PostingDAO;
import com.example.selfmadeBlog.DAO.UserDAO;
import com.example.selfmadeBlog.dto.PostingDTO;
import com.example.selfmadeBlog.model.Posting;
import com.example.selfmadeBlog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class PostingService {
    @Autowired
    PostingDAO postingDAO;
    @Autowired
    UserDAO userDAO;

    public void savePosting(PostingDTO postingDTO) throws SQLException {
        Posting posting = postingDTO.getPostingObj();
        User user = userDAO.findUserByIdx(/*postingDTO.getUser_idx()*/ 1);

        postingDAO.save(posting, user);
    }
}
