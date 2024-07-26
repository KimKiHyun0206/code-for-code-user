package com.user.codeforcodeuser.user.dto.request;

import lombok.Data;

@Data
public class UserRegisterRequest {
    private String Id;
    private String password;
    private String nickName;
}
