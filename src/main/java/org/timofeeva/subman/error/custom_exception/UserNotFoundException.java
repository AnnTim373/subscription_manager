package org.timofeeva.subman.error.custom_exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends SubManException {

    public UserNotFoundException() {
        super("User not found", HttpStatus.BAD_REQUEST);
    }

}
