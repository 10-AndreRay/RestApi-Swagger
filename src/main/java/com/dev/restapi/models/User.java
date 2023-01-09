package com.dev.restapi.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
    private Integer id;
    private String login;
    private String password;

    public User(){}

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
