package com.tommenx.exception;

public class UserAireadyExistException extends Exception {
    public UserAireadyExistException(String s) {
        super(s);
    }

    public UserAireadyExistException(Exception e) {
        super(e);
    }

    public UserAireadyExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
