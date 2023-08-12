package com.example.selfmadeBlog.DAO;

import com.example.selfmadeBlog.model.Posting;
import com.example.selfmadeBlog.model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


//@RunWith(SpringJUnit4ClassRunner.class)
@ExtendWith(SpringExtension.class)
//@ContextConfiguration(locations = "/applicationContext.xml")
class PostingDAOTest {

    ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");

    UserDAO userDAO = context.getBean(UserDAO.class);
    PostingDAO postingDAO = context.getBean(PostingDAO.class);

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
        Assertions.assertThat(findPosting.getTitle()).isEqualTo(posting.getTitle());
        Assertions.assertThat(findPosting.getContent()).isEqualTo(posting.getContent());
        System.out.println("posting = " + posting.getUser_idx());
        System.out.println("findPosting = " + findPosting.getUser_idx());
        Assertions.assertThat(findPosting.getUser_idx()).isEqualTo(posting.getUser_idx());
    }
}