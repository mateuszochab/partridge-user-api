package com.ochabmateusz.partridge.partridgeuserapi.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@NoArgsConstructor @Getter
public class UserCore {

    @NotNull
    @NotEmpty
    @Size(min = 2, message = "field Name is expected to contains atleast 2 characters")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Accept only lowercase, upperacase characters")
    @Field(value = "name")
    private String name;


    @Setter
    @NotNull
    @NotEmpty
    @Size(min = 8, message = "Password should have atleast 8 characters")
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$", message = "atleast one uppercase, one lowercase character and one number")
    @Field(value = "password")
    private String password;


    @NotNull
    @NotEmpty
    @Size(min = 5, message = "Username should have atleast 5 characters")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Accept only alphanumeric values")
    @Indexed(unique = true)
    @Field(value = "nickname")
    private String nickname;


    @Setter
    @NotNull
    @Pattern(regexp = "^[A-Za-z0-9._%-+]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}", message = "enter valid email adress")
    @NotEmpty
    @Field(value = "email")
    @Indexed(unique = true)
    private String email;

    public UserCore(String name, String password, String nickname, String email) {
        this.name = name;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
    }


}