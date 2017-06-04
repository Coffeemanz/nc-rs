package com.zhyshkevich.dao.implementations;

import com.zhyshkevich.dao.interfaces.BillDao;
import com.zhyshkevich.entitites.BillsEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by Сергей on 30.05.2017.
 */


@Repository
public class BillDaoImpl extends AbstractDao<BillsEntity> implements BillDao{

    private static final String FROM_BILLS = "from BillsEntity";

    public BillDaoImpl() {
        super(BillsEntity.class, FROM_BILLS);
    }
}
