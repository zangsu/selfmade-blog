package com.example.selfmadeBlog.DAO;

import com.example.selfmadeBlog.model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(locations = "/applicationContext.xml")
class userDAOTest {

    @Autowired
    private UserDAO userDAO;

    User user = new User("userId", "userPassword");

    @Test
    public void saveTest() throws SQLException, ClassNotFoundException {
        userDAO.save(user);
    }

    @Test
    public void findUserByIdx() throws Exception{
        //given
        userDAO.save(user);

        //when
        User userByIdx = userDAO.findUserByIdx(user.getIdx());

        //then
        Assertions.assertThat(user.getIdx()).isEqualTo(userByIdx.getIdx());
        Assertions.assertThat(user.getId()).isEqualTo(userByIdx.getId());
        Assertions.assertThat(user.getPassword()).isEqualTo(userByIdx.getPassword());
    }
}