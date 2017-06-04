package com.zhyshkevich.dao.implementations;

import com.zhyshkevich.dao.interfaces.OrderDao;
import com.zhyshkevich.dao.interfaces.WaiterDao;
import com.zhyshkevich.entitites.WaitersEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by Сергей on 30.05.2017.
 */

@Repository
public class WaitersDaoImpl extends AbstractDao<WaitersEntity> implements WaiterDao {

    private static final String FROM_CLIENTS = "from WaitersEntity";

    public WaitersDaoImpl() {
        super(WaitersEntity.class, FROM_CLIENTS);
    }
}
