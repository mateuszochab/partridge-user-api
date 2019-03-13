package com.ochabmateusz.partridge.partridgeuserapi.business;

import com.ochabmateusz.partridge.partridgeuserapi.entity.User;
import com.ochabmateusz.partridge.partridgeuserapi.entity.UserCore;
import com.ochabmateusz.partridge.partridgeuserapi.repository.MongoRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceBusinessTest {


    @InjectMocks
    private UserServiceBusiness userServiceBusiness;

    @Mock
    private MongoRepo mongoRepo;

    @Test
    public void getAllUsers() {

        when(mongoRepo.findAll()).thenReturn(Arrays.asList(new User(new UserCore("Iguana1","Ziomek12345","Iguana123456","igga@gmail.com")),
                new User(new UserCore("Iguana1","Ziomek12345","Iguana123456","igga@gmail.com"))));

        assertEquals(2,userServiceBusiness.getAllUsers().size());

    }

    @Test
    public void getUserByNickName() {
        when(mongoRepo.findByNickNameQuery("Iguana123456")).thenReturn(new User(new UserCore("Iguana1","Ziomek12345","Iguana123456","igga@gmail.com")));


        assertEquals("Iguana123456",userServiceBusiness.getUserByNickName("Iguana123456").getUserCore().getNickname());

    }

    @Test
    public void getPassword() {
        when(mongoRepo.findByNickNameQuery("Iguana123456")).thenReturn(new User(new UserCore("Iguana1","Ziomek12345","Iguana123456","igga@gmail.com")));


        assertEquals("Ziomek12345",userServiceBusiness.getUserByNickName("Iguana123456").getUserCore().getPassword());
    }

    @Test
    public void getEmail() {
        when(mongoRepo.findByNickNameQuery("Iguana123456")).thenReturn(new User(new UserCore("Iguana1","Ziomek12345","Iguana123456","igga@gmail.com")));


        assertEquals("igga@gmail.com",userServiceBusiness.getUserByNickName("Iguana123456").getUserCore().getEmail());
    }

    @Test
    public void getName() {
        when(mongoRepo.findByNickNameQuery("Iguana123456")).thenReturn(new User(new UserCore("Iguana1","Ziomek12345","Iguana123456","igga@gmail.com")));


        assertEquals("Iguana1",userServiceBusiness.getUserByNickName("Iguana123456").getUserCore().getName());
    }


    @Test
    public void getAllNotConfirmed() {
        when(mongoRepo.findAllNotConfirmed(false)).thenReturn(Arrays.asList(new User(new UserCore("Iguana1","Ziomek12345","Iguana123456","igga@gmail.com")),
                new User(new UserCore("Iguana1","Ziomek12345","Iguana123456","igga@gmail.com")),
                new User(new UserCore("Iguana1","Ziomek12345","Iguana123456","igga@gmail.com"))));

        assertEquals(3,userServiceBusiness.getAllNotConfirmed().size());


    }

    @Test
    public void getAllModified() {
        when(mongoRepo.findAllModified()).thenReturn(Arrays.asList(new User(new UserCore("Iguana1","Ziomek12345","Iguana123456","igga@gmail.com")),
                new User(new UserCore("Iguana1","Ziomek12345","Iguana123456","igga@gmail.com")),
                new User(new UserCore("Iguana1","Ziomek12345","Iguana123456","igga@gmail.com"))));


        assertEquals(3, userServiceBusiness.getAllModified().size());

    }

    @Test
    public void confirmUser() {
//
//        when(mongoRepo.findByNickNameQuery("Iguana123456")).thenReturn(new User(new UserCore("Iguana1","Ziomek12345","Iguana123456","igga@gmail.com")));
//        when(mongoRepo.save(mongoRepo.findByNickNameQuery("Iguana123456") )).thenReturn()
//        userServiceBusiness.confirmUser("Iguana123456");
//
//        assertTrue();

    }

    @Test
    public void getAllByCreatedDate() {
    }

    @Test
    public void getRole() {
    }

    @Test
    public void setAdmin() {
    }

    @Test
    public void setPaid() {
    }
}