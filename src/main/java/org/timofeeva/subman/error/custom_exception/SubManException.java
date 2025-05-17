package org.timofeeva.subman.error.custom_exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@Data
@EqualsAndHashCode(callSuper = true)
public abstract class SubManException extends RuntimeException {

    private HttpStatus statusCode;

    public SubManException(String message, HttpStatus statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

}
