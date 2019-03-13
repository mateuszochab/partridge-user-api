package com.ochabmateusz.partridge.partridgeuserapi.service;

import com.ochabmateusz.partridge.partridgeuserapi.entity.User;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.List;



@Component
public interface UserService {

    List<User> getAllUsers();

    User getUserByNickName(String name);


    String getPassword(String name);

    String getEmail(String name);

    String getName(String name);

    String getCreatedDate(String name);

    List<User> getAllNotConfirmed();

    List<User> getAllModified();

    void confirmUser(String nickname);

    List<User> getAllByCreatedDate(String date) throws ParseException;

    String getRole(String nickname);

    void setAdmin(String nickname);

    void setPaid(String nickname);
}
