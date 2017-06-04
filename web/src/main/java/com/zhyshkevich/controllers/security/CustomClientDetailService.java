package com.zhyshkevich.controllers.security;

import com.zhyshkevich.dao.implementations.ClientDaoImpl;
import com.zhyshkevich.dao.interfaces.ClientDao;
import com.zhyshkevich.entitites.ClientsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 * Created by Сергей on 01.06.2017.
 */
@Service
public class CustomClientDetailService implements UserDetailsService{

    @Autowired
    ClientDao clientDao;

    @Override
    public UserDetails loadUserByUsername(String client_email) throws UsernameNotFoundException {
        System.out.println(client_email);
        ClientsEntity clientsEntityr = clientDao.getByEmail(client_email);
        if (clientsEntityr == null) {
            throw new UsernameNotFoundException("No user with such email: " + client_email);
        } else {
            return new CustomClientDetails(clientsEntityr);
        }
    }
}
