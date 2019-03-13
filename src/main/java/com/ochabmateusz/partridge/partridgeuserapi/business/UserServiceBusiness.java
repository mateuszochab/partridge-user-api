package com.ochabmateusz.partridge.partridgeuserapi.business;

import com.ochabmateusz.partridge.partridgeuserapi.entity.Role;
import com.ochabmateusz.partridge.partridgeuserapi.entity.User;
import com.ochabmateusz.partridge.partridgeuserapi.repository.MongoRepo;
import com.ochabmateusz.partridge.partridgeuserapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceBusiness implements UserService {


    private final MongoRepo mongoRepo;

    @Autowired
    public UserServiceBusiness(MongoRepo mongoRepo) {

        this.mongoRepo = mongoRepo;
    }


    @Override
    public List<User> getAllUsers() {
        return mongoRepo.findAll();
    }

    @Override
    public User getUserByNickName(String nickname) {
        return this.mongoRepo.findByNickNameQuery(nickname);
    }

    @Override
    public String getPassword(String nickname) {
        User user = getUserByNickName(nickname);
        return user.getUserCore().getPassword();
    }

    @Override
    public String getEmail(String nickname) {
        User user = getUserByNickName(nickname);
        return user.getUserCore().getEmail();
    }

    @Override
    public String getName(String nickname) {
        User user = getUserByNickName(nickname);
        return user.getUserCore().getNickname();

    }

    @Override
    public String getCreatedDate(String nickname) {
        User user = getUserByNickName(nickname);
        return user.getCreatedDate().toString();

    }

    @Override
    public List<User> getAllNotConfirmed() {
        return this.mongoRepo.findAllNotConfirmed(false);
    }

    @Override
    public List<User> getAllModified() {
        return this.mongoRepo.findAllModified();
    }

    @Override
    public void confirmUser(String nickname) {
        User user = getUserByNickName(nickname);
        user.setConfirmed(true);
        this.mongoRepo.save(user);

    }

    @Override
    public List<User> getAllByCreatedDate(String date) throws ParseException {
        Date dat=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").parse(date);
        return this.mongoRepo.findAllbyCreatedDate(dat);
    }

    @Override
    public String getRole(String nickname) {
        User user = getUserByNickName(nickname);
        return user.getRole().toString();
    }

    @Override
    public void setAdmin(String nickname) {
        User user = getUserByNickName(nickname);
        user.setRole(Role.ADMIN);
        this.mongoRepo.save(user);
    }

    @Override
    public void setPaid(String nickname) {
        User user = getUserByNickName(nickname);

        user.setRole(Role.USERPAID);

        this.mongoRepo.save(user);

    }


}
