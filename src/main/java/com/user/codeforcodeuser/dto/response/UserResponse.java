package com.user.codeforcodeuser.dto.response;

import com.user.codeforcodeuser.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponse {
    private String id;
    private String password;
    private String nickName;
    private Integer score;


    public static UserResponse from(User user){
        return new UserResponse(
                user.getId(),
                user.getPassword(),
                user.getNickName(),
                user.getScore()
        );
    }
}