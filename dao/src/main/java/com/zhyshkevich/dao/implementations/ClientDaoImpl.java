package com.zhyshkevich.dao.implementations;

import com.zhyshkevich.dao.interfaces.ClientDao;
import com.zhyshkevich.entitites.ClientsEntity;
import com.zhyshkevich.exceptions.DaoException;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;
import org.apache.log4j.Logger;

/**
 * Created by Сергей on 30.05.2017.
 */

@Repository
public class ClientDaoImpl extends AbstractDao<ClientsEntity> implements ClientDao{

    private static Logger logger = Logger.getLogger(ClientDaoImpl.class);

    private static final String FROM_CLIENTS = "from ClientsEntity";
    private static final String FROM_CLIENTS_WHERE_EMAIL;

    static {
        FROM_CLIENTS_WHERE_EMAIL = "from ClientsEntity where client_email=:client_email";
    }

    public ClientDaoImpl() {
        super(ClientsEntity.class, FROM_CLIENTS);
    }



    @Override
    public ClientsEntity getByEmail(String client_email) {
        ClientsEntity clientsEntity;
        try {
            clientsEntity = (ClientsEntity) entityManager
                    .createQuery(FROM_CLIENTS_WHERE_EMAIL)
                    .setParameter("client_email", client_email)
                    .getResultList()
                    .get(0);
            logger.debug("User: " + clientsEntity + " successfully found!");
        } catch (HibernateException e) {
            logger.error("Error was thrown in UserDaoImpl method getByEmail: " + e);
            throw new DaoException(e);
        }
        return clientsEntity;
    }
}
