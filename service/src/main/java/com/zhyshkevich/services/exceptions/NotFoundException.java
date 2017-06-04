package com.zhyshkevich.services.exceptions;

/**
 * Created by Сергей on 31.05.2017.
 */
public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        super();
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }
}