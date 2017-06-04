package com.zhyshkevich.dao.implementations;

import com.zhyshkevich.dao.interfaces.MenuDao;
import com.zhyshkevich.entitites.MenuEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by Сергей on 30.05.2017.
 */

@Repository
public class MenuDaoImpl extends AbstractDao<MenuEntity> implements MenuDao {

    private static final String FROM_CLIENTS = "from MenuEntity";

    public MenuDaoImpl() {
        super(MenuEntity.class, FROM_CLIENTS);
    }
}
