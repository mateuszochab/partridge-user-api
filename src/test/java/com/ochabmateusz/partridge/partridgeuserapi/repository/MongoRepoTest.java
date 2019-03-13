package com.ochabmateusz.partridge.partridgeuserapi.repository;

import com.ochabmateusz.partridge.partridgeuserapi.entity.User;
import com.ochabmateusz.partridge.partridgeuserapi.entity.UserCore;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;


@EnableMongoAuditing
@DataMongoTest
@RunWith(SpringRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class MongoRepoTest {

    @Autowired
    private MongoRepo mongoRepo;


    @Before
    public void setUp() throws Exception {
        mongoRepo.save(new User(new UserCore("Iguana1","Ziomek12345","Iguana123456","igga@gmail.com")));
        mongoRepo.save(new User(new UserCore("Iguana1","Ziomek12345","Iguana1234567","igga2@gmail.com")));
        mongoRepo.save(new User(new UserCore("Iguana1","Ziomek12345","Iguana12345678","igga3@gmail.com")));
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void findAllTest(){
//        mongoRepo.save(new User(new UserCore("Iguana1","Ziomek12345","Iguana123456","igga@gmail.com")));
//        mongoRepo.save(new User(new UserCore("Iguana1","Ziomek12345","Iguana1234567","igga2@gmail.com")));
//        mongoRepo.save(new User(new UserCore("Iguana1","Ziomek12345","Iguana12345678","igga3@gmail.com")));


        List<User> db=mongoRepo.findAll();

        assertEquals(3,db.size());

    }


    @Test
    public void findByNameQuery() {


        User user= mongoRepo.findByNickNameQuery("Iguana123456");
        assertNotNull(user);
        assertEquals("Iguana123456",user.getUserCore().getNickname());
        assertEquals("igga@gmail.com",user.getUserCore().getEmail());


    }


    @Test
    public void findAllModified() {

        User user=mongoRepo.findByNickNameQuery("Iguana123456");
        user.setModifiedDate(new Date());
        mongoRepo.save(user);

        assertEquals(1,mongoRepo.findAllModified().size());
        assertNotNull(mongoRepo.findAllModified().get(0).getModifiedDate());
    }
}