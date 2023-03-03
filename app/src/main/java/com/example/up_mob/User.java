package com.example.up_mob;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String email;
    private String nickName;
    private String avatar;
    private String token;

    User (int id,String email,String nickName,String avatar,String token){
        this.id=  id;
        this.email= email;
        this.nickName= nickName;
        this.avatar= avatar;
        this.token= token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
