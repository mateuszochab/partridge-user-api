package com.ochabmateusz.partridge.partridgeuserapi.controller;


import com.ochabmateusz.partridge.partridgeuserapi.entity.User;
import com.ochabmateusz.partridge.partridgeuserapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {

        this.userService = userService;
    }


    @GetMapping("/findByNickName/{nickname}")
    public User findUserByNickName(@PathVariable(value = "nickname") String nickname){


       return this.userService.getUserByNickName(nickname);
    }

    @GetMapping("/getPassword/{nickname}")
    public String getPassword(@PathVariable(value = "nickname") String nickname){
        return this.userService.getPassword(nickname);
    }
    @GetMapping("/getEmail/{nickname}")
    public String getEmail(@PathVariable(value = "nickname") String nickname){
        return this.userService.getEmail(nickname);
    }
    @GetMapping("/getName/{nickname}")
    public String getName(@PathVariable(value = "nickname") String nickname){
        return this.userService.getName(nickname);
    }
    @GetMapping("/getCreatedDate/{nickname}")
    public String getCreatedDate(@PathVariable(value = "nickname") String nickname){
        return this.userService.getCreatedDate(nickname);
    }










}
