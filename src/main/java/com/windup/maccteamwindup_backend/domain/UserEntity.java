package com.windup.maccteamwindup_backend.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String userId;
    private String password;

    protected UserEntity(){}
    private UserEntity(String name, String userId, String password){
        this.name = name;
        this.userId = userId;
        this.password = password;
    }
    public static UserEntity of(String name, String userId, String password){
        return new UserEntity(name,userId,password);
    }
}
