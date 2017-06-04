package com.zhyshkevich.controllers.security.service;

/**
 * Created by Сергей on 04.06.2017.
 */
public interface LoginService {
    void authenticate(String email, String password);
}
