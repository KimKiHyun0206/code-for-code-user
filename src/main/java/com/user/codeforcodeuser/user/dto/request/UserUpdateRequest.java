package com.user.codeforcodeuser.user.dto.request;

import lombok.Data;

@Data
public class UserUpdateRequest {
    private String id;
    private String password;
    private String nickName;
}
