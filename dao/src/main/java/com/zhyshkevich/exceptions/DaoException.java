package com.zhyshkevich.exceptions;

/**
 * Created by Сергей on 30.05.2017.
 */
public class DaoException extends RuntimeException {

    public DaoException() {
        super();
    }

    public DaoException(String message) {
        super(message);
    }

    public DaoException(Throwable cause) {
        super(cause);
    }
}