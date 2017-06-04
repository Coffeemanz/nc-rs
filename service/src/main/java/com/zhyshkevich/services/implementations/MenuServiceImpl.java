package com.zhyshkevich.services.implementations;

import com.zhyshkevich.dao.interfaces.MenuDao;
import com.zhyshkevich.entitites.MenuEntity;
import com.zhyshkevich.exceptions.DaoException;
import com.zhyshkevich.services.dto.DtoConverter;
import com.zhyshkevich.services.dto.MenuDto;
import com.zhyshkevich.services.exceptions.ServiceException;
import com.zhyshkevich.services.interfaces.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Сергей on 31.05.2017.
 */
@Service
@Transactional(rollbackFor = DaoException.class)
public class MenuServiceImpl implements MenuService {

    private final Logger logger = Logger.getLogger(BillServiceImpl.class);

    @Autowired
    MenuDao menuDao;

    @Override
    public int save(MenuDto menuDto) {
        MenuEntity menuEntity = DtoConverter.MenuDtoToMenu(menuDto);
        try {
            menuDao.save(menuEntity);
            logger.debug("Bill: " + menuEntity + " successfully saved!");
        } catch (DaoException e) {
            logger.error("Error was thrown in BillServiceImpl method save: " + e);
            throw new ServiceException(e);
        }
        return menuEntity.getId();
    }

    @Override
    public void delete(int id) {
        try {
            menuDao.delete(id);
            logger.debug("Bill by id: " + id + " successfully deleted!");
        } catch (DaoException e) {
            logger.error("Error was thrown in BillServiceImpl method delete: " + e);
            throw new ServiceException(e);
        }

    }

    @Override
    public void update(MenuDto menuDto) {

        MenuEntity menuEntity = DtoConverter.MenuDtoToMenu(menuDto);
        try {
            menuDao.update(menuEntity);
            logger.debug("Bill: " + menuEntity + " successfully updated!");
        } catch (DaoException e) {
            logger.error("Error was thrown in BillServiceImpl method update: " + e);
            throw new ServiceException(e);
        }

    }

    @Override
    public List<MenuDto> getAll() {
        List<MenuDto> billDtos = new ArrayList<>();
        try {
            List<MenuEntity> billsEntities = menuDao.getAll();
            logger.debug("All bills successfully found!");

            for (MenuEntity menuEntity : billsEntities) {
                MenuDto menuDto = DtoConverter.menuToMenuDto(menuEntity);
                billDtos.add(menuDto);
            }
        } catch (DaoException e) {
            logger.error("Error was thrown in BillServiceImpl method getAll: " + e);
            throw new ServiceException(e);
        }
        return billDtos;

    }

    @Override
    public MenuDto get(int id) {
        MenuDto menuDto;
        try {
            MenuEntity menuEntity = menuDao.getById(id);
            logger.debug("Bill by id: " + id + " successfully found!");
            menuDto = DtoConverter.menuToMenuDto(menuEntity);

        } catch (DaoException e) {
            logger.error("Error was thrown in BillServiceImpl method get: " + e);
            throw new ServiceException(e);
        }
        return menuDto;
    }
}
