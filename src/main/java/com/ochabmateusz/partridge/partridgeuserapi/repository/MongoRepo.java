package com.ochabmateusz.partridge.partridgeuserapi.repository;

import com.ochabmateusz.partridge.partridgeuserapi.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface MongoRepo extends MongoRepository<User, String> {




    @Query("{'userCore.nickname' : ?0}")
    User findByNickNameQuery(String nickname);

    @Query("{confirmed : ?0}")
    List<User> findAllNotConfirmed(Boolean confirmed);

    @Query("{'modifiedDate' : {$ne : null} }")
    List<User> findAllModified();

    @Query("{createdDate : ?0}")
    List<User> findAllbyCreatedDate(Date date);






}
