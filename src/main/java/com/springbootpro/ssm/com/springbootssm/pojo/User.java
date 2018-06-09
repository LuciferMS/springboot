package com.springbootpro.ssm.com.springbootssm.pojo;

import lombok.Data;

@Data
public class User {
    private String id;
    private String username;
    private String nickname;
    private String password;

    public User() {
    }

    public User(String id, String username, String nickname, String password) {
        this.id = id;
        this.username = username;
        this.nickname = nickname;
        this.password = password;
    }
}
