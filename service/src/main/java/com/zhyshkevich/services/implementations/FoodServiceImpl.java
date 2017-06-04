package com.zhyshkevich.services.implementations;

import com.zhyshkevich.dao.interfaces.FoodDao;
import com.zhyshkevich.entitites.FoodEntity;
import com.zhyshkevich.exceptions.DaoException;
import com.zhyshkevich.services.dto.DtoConverter;
import com.zhyshkevich.services.dto.FoodDto;
import com.zhyshkevich.services.exceptions.ServiceException;
import com.zhyshkevich.services.interfaces.FoodService;
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
public class FoodServiceImpl  implements FoodService{

    private final Logger logger = Logger.getLogger(BillServiceImpl.class);

    @Autowired
    FoodDao foodDao;

    @Override
    public int save(FoodDto foodDto) {
        FoodEntity foodEntity = DtoConverter.FoodDtoToFood(foodDto);
        try {
            foodDao.save(foodEntity);
            logger.debug("Bill: " + foodEntity + " successfully saved!");
        } catch (DaoException e) {
            logger.error("Error was thrown in BillServiceImpl method save: " + e);
            throw new ServiceException(e);
        }
        return foodEntity.getId();
    }

    @Override
    public void delete(int id) {
        try {
            foodDao.delete(id);
            logger.debug("Bill by id: " + id + " successfully deleted!");
        } catch (DaoException e) {
            logger.error("Error was thrown in BillServiceImpl method delete: " + e);
            throw new ServiceException(e);
        }

    }

    @Override
    public void update(FoodDto foodDto) {

        FoodEntity foodEntity = DtoConverter.FoodDtoToFood(foodDto);
        try {
            foodDao.update(foodEntity);
            logger.debug("Bill: " + foodEntity + " successfully updated!");
        } catch (DaoException e) {
            logger.error("Error was thrown in BillServiceImpl method update: " + e);
            throw new ServiceException(e);
        }

    }

    @Override
    public List<FoodDto> getAll() {
        List<FoodDto> billDtos = new ArrayList<>();
        try {
            List<FoodEntity> billsEntities = foodDao.getAll();
            logger.debug("All bills successfully found!");

            for (FoodEntity foodEntity : billsEntities) {
                FoodDto foodDto = DtoConverter.foodToFoodDto(foodEntity);
                billDtos.add(foodDto);
            }
        } catch (DaoException e) {
            logger.error("Error was thrown in BillServiceImpl method getAll: " + e);
            throw new ServiceException(e);
        }
        return billDtos;

    }

    @Override
    public FoodDto get(int id) {
        FoodDto foodDto;
        try {
            FoodEntity foodEntity = foodDao.getById(id);
            logger.debug("Bill by id: " + id + " successfully found!");
            foodDto = DtoConverter.foodToFoodDto(foodEntity);

        } catch (DaoException e) {
            logger.error("Error was thrown in BillServiceImpl method get: " + e);
            throw new ServiceException(e);
        }
        return foodDto;
    }



}
