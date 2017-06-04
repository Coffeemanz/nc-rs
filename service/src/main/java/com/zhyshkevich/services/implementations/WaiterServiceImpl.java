package com.zhyshkevich.services.implementations;

import com.zhyshkevich.dao.interfaces.WaiterDao;
import com.zhyshkevich.entitites.WaitersEntity;
import com.zhyshkevich.exceptions.DaoException;
import com.zhyshkevich.services.dto.DtoConverter;
import com.zhyshkevich.services.dto.WaiterDto;
import com.zhyshkevich.services.exceptions.ServiceException;
import com.zhyshkevich.services.interfaces.WaiterService;
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
public class WaiterServiceImpl implements WaiterService {

    private final Logger logger = Logger.getLogger(BillServiceImpl.class);

    @Autowired
    WaiterDao waiterDao;

    @Override
    public int save(WaiterDto waiterDto) {
        WaitersEntity waiterEntity = DtoConverter.WaiterDtoToWaiter(waiterDto);
        try {
            waiterDao.save(waiterEntity);
            logger.debug("Bill: " + waiterEntity + " successfully saved!");
        } catch (DaoException e) {
            logger.error("Error was thrown in BillServiceImpl method save: " + e);
            throw new ServiceException(e);
        }
        return waiterEntity.getId();
    }

    @Override
    public void delete(int id) {
        try {
            waiterDao.delete(id);
            logger.debug("Bill by id: " + id + " successfully deleted!");
        } catch (DaoException e) {
            logger.error("Error was thrown in BillServiceImpl method delete: " + e);
            throw new ServiceException(e);
        }

    }

    @Override
    public void update(WaiterDto waiterDto) {

        WaitersEntity waiterEntity = DtoConverter.WaiterDtoToWaiter(waiterDto);
        try {
            waiterDao.update(waiterEntity);
            logger.debug("Bill: " + waiterEntity + " successfully updated!");
        } catch (DaoException e) {
            logger.error("Error was thrown in BillServiceImpl method update: " + e);
            throw new ServiceException(e);
        }

    }

    @Override
    public List<WaiterDto> getAll() {
        List<WaiterDto> billDtos = new ArrayList<>();
        try {
            List<WaitersEntity> billsEntities = waiterDao.getAll();
            logger.debug("All bills successfully found!");

            for (WaitersEntity waiterEntity : billsEntities) {
                WaiterDto waiterDto = DtoConverter.waiterToWaiterDto(waiterEntity);
                billDtos.add(waiterDto);
            }
        } catch (DaoException e) {
            logger.error("Error was thrown in BillServiceImpl method getAll: " + e);
            throw new ServiceException(e);
        }
        return billDtos;

    }

    @Override
    public WaiterDto get(int id) {
        WaiterDto waiterDto;
        try {
            WaitersEntity waiterEntity = waiterDao.getById(id);
            logger.debug("Bill by id: " + id + " successfully found!");
            waiterDto = DtoConverter.waiterToWaiterDto(waiterEntity);

        } catch (DaoException e) {
            logger.error("Error was thrown in BillServiceImpl method get: " + e);
            throw new ServiceException(e);
        }
        return waiterDto;
    }
}
