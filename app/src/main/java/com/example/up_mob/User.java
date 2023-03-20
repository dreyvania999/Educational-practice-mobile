package com.example.up_mob;

import java.io.Serializable;

public class User implements Serializable {
    private String id;
    private String email;
    private String nickName;
    private String avatar;
    private String token;
    private String password;

    public User(String id, String email, String nickName, String avatar, String token) {
        this.id = id;
        this.email = email;
        this.nickName = nickName;
        this.avatar = avatar;
        this.token = token;
    }
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public String getNickName() {
        return nickName;
    }



    public String getAvatar() {
        return avatar;
    }


    public String getToken() {
        return token;
    }


}
