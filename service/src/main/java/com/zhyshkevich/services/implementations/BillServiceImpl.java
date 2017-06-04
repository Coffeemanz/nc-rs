package com.zhyshkevich.services.implementations;

import com.zhyshkevich.dao.interfaces.BillDao;
import com.zhyshkevich.entitites.BillsEntity;
import com.zhyshkevich.exceptions.DaoException;
import com.zhyshkevich.services.dto.BillDto;
import com.zhyshkevich.services.dto.DtoConverter;
import com.zhyshkevich.services.exceptions.ServiceException;
import com.zhyshkevich.services.interfaces.BillService;
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
public class BillServiceImpl implements BillService {

    private final Logger logger = Logger.getLogger(BillServiceImpl.class);

    @Autowired
    BillDao billDao;

    @Override
    public int save(BillDto billDto) {

        BillsEntity billsEntity = DtoConverter.BillDtoToBill(billDto);
        try {
            billDao.save(billsEntity);
            logger.debug("Bill: " + billsEntity + " successfully saved!");
        } catch (DaoException e) {
            logger.error("Error was thrown in BillServiceImpl method save: " + e);
            throw new ServiceException(e);
        }
        return billsEntity.getId();
    }

    @Override
    public void delete(int id) {
        try {
            billDao.delete(id);
            logger.debug("Bill by id: " + id + " successfully deleted!");
        } catch (DaoException e) {
            logger.error("Error was thrown in BillServiceImpl method delete: " + e);
            throw new ServiceException(e);
        }

    }

    @Override
    public void update(BillDto billDto) {

        BillsEntity billsEntity = DtoConverter.BillDtoToBill(billDto);
        try {
            billDao.update(billsEntity);
            logger.debug("Bill: " + billsEntity + " successfully updated!");
        } catch (DaoException e) {
            logger.error("Error was thrown in BillServiceImpl method update: " + e);
            throw new ServiceException(e);
        }

    }

    @Override
    public List<BillDto> getAll() {
        List<BillDto> billDtos = new ArrayList<>();
        try {
            List<BillsEntity> billsEntities = billDao.getAll();
            logger.debug("All bills successfully found!");

            for (BillsEntity billsEntity : billsEntities) {
                BillDto billDto = DtoConverter.billToBillDto(billsEntity);
                billDtos.add(billDto);
            }
        } catch (DaoException e) {
            logger.error("Error was thrown in BillServiceImpl method getAll: " + e);
            throw new ServiceException(e);
        }
        return billDtos;

    }

    @Override
    public BillDto get(int id) {
        BillDto billDto;
        try {
            BillsEntity billsEntity = billDao.getById(id);
            logger.debug("Bill by id: " + id + " successfully found!");
            billDto = DtoConverter.billToBillDto(billsEntity);

        } catch (DaoException e) {
            logger.error("Error was thrown in BillServiceImpl method get: " + e);
            throw new ServiceException(e);
        }
        return billDto;
    }
}
