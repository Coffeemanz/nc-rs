package com.zhyshkevich.services.implementations;

import com.zhyshkevich.dao.interfaces.OrderDao;
import com.zhyshkevich.entitites.OrdersEntity;
import com.zhyshkevich.exceptions.DaoException;
import com.zhyshkevich.services.dto.DtoConverter;
import com.zhyshkevich.services.dto.OrderDto;
import com.zhyshkevich.services.exceptions.NotFoundException;
import com.zhyshkevich.services.exceptions.ServiceException;
import com.zhyshkevich.services.interfaces.OrderService;
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
public class OrderServiceImpl implements OrderService {

    private final Logger logger = Logger.getLogger(BillServiceImpl.class);

    @Autowired
    OrderDao orderDao;

    @Override
    public int save(OrderDto orderDto) {
        System.out.println("-------------------------");
        System.out.println("Client id from dto in Service Save");
        System.out.println(orderDto.getClientId());
        System.out.println("-------------------------");

        OrdersEntity orderEntity = DtoConverter.OrderDtoToOrder(orderDto);

        System.out.println("-------------------------");
        System.out.println("Client id from entity in Service Save");
        System.out.println(orderEntity.getClient());
        System.out.println("-------------------------");
        try {

            orderDao.save(orderEntity);
            logger.debug("Bill: " + orderEntity + " successfully saved!");
        } catch (DaoException e) {
            logger.error("Error was thrown in BillServiceImpl method save: " + e);
            throw new ServiceException(e);
        }
        return orderEntity.getId();
    }

    @Override
    public void delete(int id) {
        try {
            orderDao.delete(id);
            logger.debug("Bill by id: " + id + " successfully deleted!");
        } catch (DaoException e) {
            logger.error("Error was thrown in BillServiceImpl method delete: " + e);
            throw new ServiceException(e);
        }

    }

    @Override
    public void update(OrderDto orderDto) {

        OrdersEntity orderEntity = DtoConverter.OrderDtoToOrder(orderDto);
        try {
            orderDao.update(orderEntity);
            logger.debug("Bill: " + orderEntity + " successfully updated!");
        } catch (DaoException e) {
            logger.error("Error was thrown in BillServiceImpl method update: " + e);
            throw new ServiceException(e);
        }

    }

    @Override
    public List<OrderDto> getAll() {
        List<OrderDto> billDtos = new ArrayList<>();
        try {
            List<OrdersEntity> billsEntities = orderDao.getAll();
            logger.debug("All bills successfully found!");

            for (OrdersEntity orderEntity : billsEntities) {
                OrderDto orderDto = DtoConverter.orderToOrderDto(orderEntity);
                billDtos.add(orderDto);
            }
        } catch (DaoException e) {
            logger.error("Error was thrown in BillServiceImpl method getAll: " + e);
            throw new ServiceException(e);
        }
        return billDtos;

    }

    @Override
    public OrderDto get(int id) {
        OrderDto orderDto;
        try {
            OrdersEntity orderEntity = orderDao.getById(id);
//            if (orderEntity == null)
//            {
//                throw new NotFoundException("Order not found!");
//            }
            System.out.println("-------------");
            System.out.println("Order entity from service");
            System.out.println(orderEntity);
            System.out.println("-------------");
            logger.debug("Bill by id: " + id + " successfully found!");

            orderDto = DtoConverter.orderToOrderDto(orderEntity);

            System.out.println("-------------");
            System.out.println("Order dto from service");
            System.out.println(orderDto);
            System.out.println("-------------");

        } catch (DaoException e) {
            logger.error("Error was thrown in BillServiceImpl method get: " + e);
            throw new ServiceException(e);
        }
        return orderDto;
    }
}
