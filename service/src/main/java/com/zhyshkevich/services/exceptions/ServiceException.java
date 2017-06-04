package com.zhyshkevich.services.exceptions;

/**
 * Created by Сергей on 31.05.2017.
 */
public class ServiceException extends RuntimeException {

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }
}