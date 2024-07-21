package com.user.codeforcodeuser.domain;

import com.user.codeforcodeuser.common.BaseEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String password;
    private String nickName;
    private Integer score;

    public User(String password, String nickName){
        this.password = password;
        this.nickName = nickName;
        this. score = 0;
    }

    public void update(String id, String password, String nickName){
        this.id = id;
        this.password = password;
        this.nickName = nickName;
    }

    public void addScore(int point){
        this.score += point;
    }
}
