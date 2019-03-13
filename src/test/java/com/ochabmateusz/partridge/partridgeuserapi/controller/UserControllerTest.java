package com.ochabmateusz.partridge.partridgeuserapi.controller;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.ochabmateusz.partridge.partridgeuserapi.entity.User;
import com.ochabmateusz.partridge.partridgeuserapi.entity.UserCore;
import com.ochabmateusz.partridge.partridgeuserapi.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;


    @Test
    public void findUserByNickName() throws Exception {

        when(userService.getUserByNickName("Iguana123456")).thenReturn(new User(new UserCore("Iguana1","Ziomek12345","Iguana123456","igga@gmail.com")));

        RequestBuilder requestBuilder= MockMvcRequestBuilders
                .get("/api/user/findByNickName/{nickname}","Iguana123456")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult=mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":null,\"userCore\":{\"name\":\"Iguana1\",\"password\":\"Ziomek12345\",\"nickname\":\"Iguana123456\",\"email\":\"igga@gmail.com\"},\"confirmed\":false,\"role\":\"USER\",\"modifiedDate\":null}"))
                .andReturn();


    }


    @Test
    public void findUserByNickName_checkNumberOfReturnedElements() throws Exception {

        when(userService.getUserByNickName("Iguana123456")).thenReturn(new User(new UserCore("Iguana1","Ziomek12345","Iguana123456","igga@gmail.com")));

        RequestBuilder requestBuilder= MockMvcRequestBuilders
                .get("/api/user/findByNickName/{nickname}","Iguana123456")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult=mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andReturn();


        DocumentContext context= JsonPath.parse(mvcResult.getResponse().getContentAsString());
        int lenght=context.read("$.length()");
        assertThat(lenght).isEqualTo(6);


    }


    @Test
    public void getPassword() throws Exception {
        when(userService.getPassword("Iguana123456")).thenReturn("haslo");

        RequestBuilder requestBuilder= MockMvcRequestBuilders
                .get("/api/user/getPassword/{nickname}","Iguana123456")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult=mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string("haslo"))
                .andReturn();

    }

    @Test
    public void getEmail() throws Exception {
        when(userService.getEmail("Iguana123456")).thenReturn("email@email.com");

        RequestBuilder requestBuilder= MockMvcRequestBuilders
                .get("/api/user/getEmail/{nickname}","Iguana123456")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult=mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string("email@email.com"))
                .andReturn();
    }

    @Test
    public void getName() throws Exception {
        when(userService.getName("Iguana123456")).thenReturn("Iga");

        RequestBuilder requestBuilder= MockMvcRequestBuilders
                .get("/api/user/getName/{nickname}","Iguana123456")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult=mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string("Iga"))
                .andReturn();
    }

    @Test
    public void getCreatedDate() throws Exception {
        when(userService.getCreatedDate("Iguana123456")).thenReturn("12:13:14");

        RequestBuilder requestBuilder= MockMvcRequestBuilders
                .get("/api/user/getCreatedDate/{nickname}","Iguana123456")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult=mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andReturn();

        assertEquals( "12:13:14",mvcResult.getResponse().getContentAsString());
    }
}