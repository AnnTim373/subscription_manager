package org.timofeeva.subman.error.custom_exception;

import org.springframework.http.HttpStatus;

public class SubscriptionNotFoundException extends SubManException {

    public SubscriptionNotFoundException() {
        super("Subscription not found", HttpStatus.BAD_REQUEST);
    }

}
