package com.ochabmateusz.partridge.partridgeuserapi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import java.util.Date;

@NoArgsConstructor @Getter
@Document(collection="user")
public class User {

    @Id
    @GeneratedValue
    private String id;

    @Field(value = "userCore")
    private UserCore userCore;

    @Setter
    @Field(value = "confirmed")
    private boolean confirmed;


    @Setter
    @Field(value = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @CreatedDate
    @Field(value = "createdDate")
    private  Date createdDate;


    //    @Temporal(TemporalType.TIMESTAMP)
//    @LastModifiedDate
    @Setter
    @Field(value = "modifiedDate")
    private Date modifiedDate;

    public User(UserCore userCore){

        this.userCore=userCore;
        this.confirmed=false;
        this.role=Role.USER;
        this.createdDate=new Date();
        this.modifiedDate=null;

    }




}
