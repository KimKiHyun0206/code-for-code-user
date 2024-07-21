package com.user.codeforcodeuser.exception;

public class UserNotFoundException extends BusinessException {
    public UserNotFoundException() {
        super(ErrorMessage.USER_NOT_FOUND_ERROR);
    }
}