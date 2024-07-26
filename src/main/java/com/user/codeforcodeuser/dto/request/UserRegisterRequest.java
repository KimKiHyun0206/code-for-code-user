package com.user.codeforcodeuser.dto.request;

import lombok.Data;

@Data
public class UserRegisterRequest {
    private String Id;
    private String password;
    private String nickName;
}
