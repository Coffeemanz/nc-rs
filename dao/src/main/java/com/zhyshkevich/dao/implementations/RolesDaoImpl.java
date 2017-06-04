package com.zhyshkevich.dao.implementations;

import com.zhyshkevich.dao.interfaces.RoleDao;
import com.zhyshkevich.entitites.RolesEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by Сергей on 01.06.2017.
 */

@Repository
public class RolesDaoImpl  extends AbstractDao<RolesEntity> implements RoleDao {


    private static final String FROM_CLIENTS = "from RolesEntity";

    public RolesDaoImpl() {
        super(RolesEntity.class, FROM_CLIENTS);
    }
}
