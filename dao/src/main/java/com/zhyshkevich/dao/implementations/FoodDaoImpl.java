package com.zhyshkevich.dao.implementations;

import com.zhyshkevich.dao.interfaces.FoodDao;
import com.zhyshkevich.entitites.FoodEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by Сергей on 30.05.2017.
 */

@Repository
public class FoodDaoImpl extends AbstractDao<FoodEntity> implements FoodDao {

    private static final String FROM_CLIENTS = "from FoodEntity";

    public FoodDaoImpl() {
        super(FoodEntity.class, FROM_CLIENTS);
    }
}
