package com.example.selfmadeBlog.DAO;

import com.example.selfmadeBlog.model.Posting;
import com.example.selfmadeBlog.model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
class PostingDAOTest {
    UserDAO userDAO = UserDAO.getUserDAO();
    PostingDAO postingDAO = PostingDAO.getPostingDAO();

    User user = new User("new user", "user password");
    Posting posting = new Posting("title1", user.getIdx(), "content1");

    @Test
    @Transactional
    public void save() throws Exception{
        //given
        userDAO.save(user);

        //when
        postingDAO.save(posting, user);

        //then
    }

    @Test
    @Transactional
    public void findByIdx() throws Exception{
        //given
        userDAO.save(user);
        postingDAO.save(posting, user);

        //when
        Posting findPosting = postingDAO.findByIdx(posting.getIdx());

        //then
        Assertions.assertThat(findPosting.getTitle()).isEqualTo(posting.getTitle());
        Assertions.assertThat(findPosting.getContent()).isEqualTo(posting.getContent());
        System.out.println("posting = " + posting.getUser_idx());
        System.out.println("findPosting = " + findPosting.getUser_idx());
        Assertions.assertThat(findPosting.getUser_idx()).isEqualTo(posting.getUser_idx());
    }
}