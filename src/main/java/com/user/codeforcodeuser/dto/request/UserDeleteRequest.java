package com.user.codeforcodeuser.dto.request;

import lombok.Data;

@Data
public class UserDeleteRequest {
    private String id;
    private String password;
}