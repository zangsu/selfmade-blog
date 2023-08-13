package com.example.selfmadeBlog.DAO;

import com.example.selfmadeBlog.SelfmadeBlogApplication;
import com.example.selfmadeBlog.exception.database.NoDataFoundedException;
import com.example.selfmadeBlog.model.Posting;
import com.example.selfmadeBlog.model.User;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@SpringJUnitConfig(classes = SelfmadeBlogApplication.class)
class PostingDAOTest {

    @Autowired
    UserDAO userDAO;

    @Autowired
    PostingDAO postingDAO;

    User user = new User("new user", "user password");
    Posting posting = new Posting("title1", user.getIdx(), "content1");

    @Test
    public void save() throws Exception{
        //given
        userDAO.save(user);

        //when
        postingDAO.save(posting, user);

        //then
    }

    @Test
    public void findByIdx() throws Exception{
        //given
        userDAO.save(user);
        postingDAO.save(posting, user);

        //when
        Posting findPosting = postingDAO.findByIdx(posting.getIdx());

        //then
        isSamePosting(posting, findPosting);
    }

    @Test
    public void update() throws Exception{
        //given
        userDAO.save(user);
        postingDAO.save(posting, user);

        //when
        Posting newPosting = new Posting();
        newPosting.setIdx(posting.getIdx());
        newPosting.setUser_idx(posting.getUser_idx());
        newPosting.setTitle("new Title");
        newPosting.setContent("new Content");

        postingDAO.update(newPosting);

        //then
        Posting newPostingByIdx = postingDAO.findByIdx(posting.getIdx());
        isSamePosting(newPostingByIdx, newPosting);
    }

    @Test
    public void delete() throws Exception{
        //given
        userDAO.save(user);
        postingDAO.save(posting, user);

        //when
        postingDAO.delete(posting.getIdx());

        //then
        Assertions.assertThatThrownBy(() -> postingDAO.findByIdx(posting.getIdx()))
                .isInstanceOf(NoDataFoundedException.class);
    }

    @AfterEach
    public void cleanUp() throws SQLException {
        postingDAO.delete(posting.getIdx());
        userDAO.delete(user.getIdx());
    }

    public void isSamePosting(Posting a, Posting b) throws Exception {
        Assertions.assertThat(a.getIdx()).isEqualTo(b.getIdx());
        Assertions.assertThat(a.getTitle()).isEqualTo(b.getTitle());
        Assertions.assertThat(a.getContent()).isEqualTo(b.getContent());
        Assertions.assertThat(a.getUser_idx()).isEqualTo(b.getUser_idx());
    }
}