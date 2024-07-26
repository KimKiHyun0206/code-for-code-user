package com.user.codeforcodeuser.exception;

public class UserNotFoundException extends BusinessException {
    public UserNotFoundException() {
        super(ErrorMessage.USER_NOT_FOUND_ERROR);
    }

    public UserNotFoundException(String reason) {
        super((ErrorMessage.USER_NOT_FOUND_ERROR), reason);
    }

    public UserNotFoundException(ErrorMessage message, String reason) {
        super(message, reason);
    }
}