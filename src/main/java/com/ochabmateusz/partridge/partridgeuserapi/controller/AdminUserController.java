package com.ochabmateusz.partridge.partridgeuserapi.controller;


import com.ochabmateusz.partridge.partridgeuserapi.entity.User;
import com.ochabmateusz.partridge.partridgeuserapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/admin/api/user")
public class AdminUserController {

    private final UserService userService;

    @Autowired
    public AdminUserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/getAll")
    public List<User> getAll(){

        return this.userService.getAllUsers();
    }

    @GetMapping("/getAllNotConfirmed")
    public List<User> getAllNotConfirmed() {

        return this.userService.getAllNotConfirmed();


    }
    @GetMapping("/getAllModified")
    public List<User> getAllModified() {

        return this.userService.getAllModified();
    }

    @GetMapping("/confirmUser/{nickname}")
    public void confirmUser(@PathVariable(value = "nickname") String nickname) {

        this.userService.confirmUser(nickname);
}

    @GetMapping("/getAllByCreatedDate/{date}")
    public List<User> getAllByCreatedDate(@PathVariable(value = "date") String date) throws ParseException {



        return this.userService.getAllByCreatedDate(date);
    }
    @GetMapping("/getRole/{nickname}")
    public String getRole(@PathVariable(value="nickname") String nickname){

    return this.userService.getRole(nickname);
    }
    @GetMapping("/setAdmin/{nickname}")
    public void setAdmin(@PathVariable(value="nickname") String nickname){

        this.userService.setAdmin(nickname);

    }

    @GetMapping("/setPaid/{nickname}")
    public void setPaid(@PathVariable(value="nickname") String nickname){

        this.userService.setPaid(nickname);

    }








}



