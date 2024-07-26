package com.user.codeforcodeuser.dto.request;

import lombok.Data;

@Data
public class UserUpdateRequest {
    private String id;
    private String password;
    private String nickName;
}
