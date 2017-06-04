package com.zhyshkevich.dao.implementations;

import com.zhyshkevich.dao.interfaces.OrderDao;
import com.zhyshkevich.entitites.OrdersEntity;
import com.zhyshkevich.exceptions.DaoException;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

/**
 * Created by Сергей on 30.05.2017.
 */

@Repository
public class OrdersDaoImpl extends AbstractDao<OrdersEntity> implements OrderDao {

    private static final String FROM_CLIENTS = "from OrdersEntity";

    public OrdersDaoImpl() {
        super(OrdersEntity.class, FROM_CLIENTS);
    }

    //public Class<OrdersEntity> persistentClass;

    @Override
    public int save(OrdersEntity entity) {
        try {


            System.out.println("------------------");
            System.out.println("NOW IN SAVE");
            System.out.println("Client id from dao");
            System.out.println(entity.getClient().getId());
            System.out.println("------------------");
            entityManager.persist(entity);


        } catch (HibernateException e) {

            throw new DaoException(e);
        }

        return entity.getId();
    }

//    @Override
//    public OrdersEntity getById(int id) {
//        OrdersEntity entity;
//        try {
//            entity = entityManager.find(persistentClass, id);
//            System.out.println("-------------");
//            System.out.println("Order entity from dao");
//            System.out.println(entity);
//            System.out.println("-------------");
//        } catch (HibernateException e) {
//            throw new DaoException(e);
//        }
//        return entity;
//    }
}
