package com.example.selfmadeBlog.DAO;

import com.example.selfmadeBlog.SelfmadeBlogApplication;
import com.example.selfmadeBlog.exception.database.NoDataFoundedException;
import com.example.selfmadeBlog.model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@SpringJUnitConfig(classes = SelfmadeBlogApplication.class)
@ActiveProfiles("testDB")
class userDAOTest {

    @Autowired
    private UserDAO userDAO;

    User user = new User("userId", "userPassword");

    @Test
<<<<<<< Updated upstream
    public void saveTest() throws SQLException, ClassNotFoundException {
=======
    @Transactional
    public void saveTest() throws SQLException {
>>>>>>> Stashed changes
        userDAO.save(user);
    }

    @Test
    public void findUserByIdx() throws Exception{
        //given
        userDAO.save(user);

        //when
        User userByIdx = userDAO.findUserByIdx(user.getIdx());

        //then
        isSameUser(user, userByIdx);
    }


    @Test
    public void update() throws Exception{
        //given
        userDAO.save(user);

        //when
        user.setId("New Id");
        user.setPassword("new Password");
        userDAO.update(user);

        //then
        User userByIdx = userDAO.findUserByIdx(user.getIdx());
        isSameUser(user, userByIdx);
    }

    @Test
    public void delete() throws Exception{
        //given
        userDAO.save(user);

        //when
        userDAO.delete(user.getIdx());

        //then
        Assertions.assertThatThrownBy(() -> userDAO.findUserByIdx(user.getIdx()))
                .isInstanceOf(NoDataFoundedException.class);
    }

    @AfterEach
    public void cleanUp() throws SQLException {
        userDAO.delete(user.getIdx());

    }
    private void isSameUser(User user1, User user2) {
        Assertions.assertThat(user1.getIdx()).isEqualTo(user2.getIdx());
        Assertions.assertThat(user1.getId()).isEqualTo(user2.getId());
        Assertions.assertThat(user1.getPassword()).isEqualTo(user2.getPassword());
    }
}
