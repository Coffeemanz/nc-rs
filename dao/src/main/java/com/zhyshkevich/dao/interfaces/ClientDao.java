package com.zhyshkevich.dao.interfaces;

import com.zhyshkevich.entitites.ClientsEntity;

/**
 * Created by Сергей on 30.05.2017.
 */
public interface ClientDao extends BaseDao<ClientsEntity> {

    ClientsEntity getByEmail (String client_email);
}
