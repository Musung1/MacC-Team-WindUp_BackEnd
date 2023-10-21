package com.windup.maccteamwindup_backend.dto;

import lombok.Data;

@Data
public class SignUpForm {
    private String userName;
    private String userId;
    private String userPw;
    public SignUpForm(String userName,String userId, String userPw){
        this.userName = userName;
        this.userId = userId;
        this.userPw = userPw;
    }
    public SignUpForm(){}

}
