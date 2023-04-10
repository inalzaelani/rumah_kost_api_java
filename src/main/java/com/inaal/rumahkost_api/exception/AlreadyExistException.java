package com.inaal.rumahkost_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class AlreadyExistException extends RuntimeException {
    public AlreadyExistException() {
        super("Data is already exist");
    }
    public AlreadyExistException(String message) {
        super(message);
    }
}
