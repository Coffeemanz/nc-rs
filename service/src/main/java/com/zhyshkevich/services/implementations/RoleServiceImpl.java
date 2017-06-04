package com.zhyshkevich.services.implementations;

import com.zhyshkevich.dao.interfaces.RoleDao;
import com.zhyshkevich.entitites.RolesEntity;
import com.zhyshkevich.exceptions.DaoException;
import com.zhyshkevich.services.dto.DtoConverter;
//import com.zhyshkevich.services.dto.RoleDto;
import com.zhyshkevich.services.dto.RoleDto;
import com.zhyshkevich.services.exceptions.ServiceException;
import com.zhyshkevich.services.interfaces.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Сергей on 01.06.2017.
 */

@Service
@Transactional(rollbackFor = DaoException.class)
public class RoleServiceImpl implements RoleService {

    private final Logger logger = Logger.getLogger(BillServiceImpl.class);

    @Autowired
    RoleDao roleDao;

    @Override
    public int save(RoleDto roleDto) {
        RolesEntity roleEntity = DtoConverter.RoleDtotoRole(roleDto);
        try {
            roleDao.save(roleEntity);
            logger.debug("Bill: " + roleEntity + " successfully saved!");
        } catch (DaoException e) {
            logger.error("Error was thrown in BillServiceImpl method save: " + e);
            throw new ServiceException(e);
        }
        return roleEntity.getId();
    }

    @Override
    public void delete(int id) {
        try {
            roleDao.delete(id);
            logger.debug("Bill by id: " + id + " successfully deleted!");
        } catch (DaoException e) {
            logger.error("Error was thrown in BillServiceImpl method delete: " + e);
            throw new ServiceException(e);
        }

    }

    @Override
    public void update(RoleDto roleDto) {

        RolesEntity roleEntity = DtoConverter.RoleDtotoRole(roleDto);
        try {
            roleDao.update(roleEntity);
            logger.debug("Bill: " + roleEntity + " successfully updated!");
        } catch (DaoException e) {
            logger.error("Error was thrown in BillServiceImpl method update: " + e);
            throw new ServiceException(e);
        }

    }

    @Override
    public List<RoleDto> getAll() {
        List<RoleDto> billDtos = new ArrayList<>();
        try {
            List<RolesEntity> billsEntities = roleDao.getAll();
            logger.debug("All bills successfully found!");

            for (RolesEntity roleEntity : billsEntities) {
                RoleDto roleDto = DtoConverter.roleToRoleDto(roleEntity);
                billDtos.add(roleDto);
            }
        } catch (DaoException e) {
            logger.error("Error was thrown in BillServiceImpl method getAll: " + e);
            throw new ServiceException(e);
        }
        return billDtos;

    }

    @Override
    public RoleDto get(int id) {
        RoleDto roleDto;
        try {
            RolesEntity roleEntity = roleDao.getById(id);
            logger.debug("Bill by id: " + id + " successfully found!");
            roleDto = DtoConverter.roleToRoleDto(roleEntity);

        } catch (DaoException e) {
            logger.error("Error was thrown in BillServiceImpl method get: " + e);
            throw new ServiceException(e);
        }
        return roleDto;
    }
}
