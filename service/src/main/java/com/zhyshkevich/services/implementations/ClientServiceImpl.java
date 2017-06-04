package com.zhyshkevich.services.implementations;

import com.zhyshkevich.dao.interfaces.ClientDao;
import com.zhyshkevich.entitites.ClientsEntity;
import com.zhyshkevich.exceptions.DaoException;
import com.zhyshkevich.services.dto.ClientDto;
import com.zhyshkevich.services.dto.DtoConverter;
import com.zhyshkevich.services.exceptions.NotFoundException;
import com.zhyshkevich.services.exceptions.ServiceException;
import com.zhyshkevich.services.interfaces.ClientService;
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
public class ClientServiceImpl implements ClientService {

    private final Logger logger = Logger.getLogger(ClientServiceImpl.class);

    @Autowired
    ClientDao clientDao;

    @Override
    public int save(ClientDto clientDto) {
        ClientsEntity clientsEntity = DtoConverter.ClientDtoToClient(clientDto);
        try {
            clientDao.save(clientsEntity);
            logger.debug("Bill: " + clientsEntity + " successfully saved!");
        } catch (DaoException e) {
            logger.error("Error was thrown in BillServiceImpl method save: " + e);
            throw new ServiceException(e);
        }
        return clientsEntity.getId();
    }

    @Override
    public void delete(int id) {
        try {
            clientDao.delete(id);
            logger.debug("Bill by id: " + id + " successfully deleted!");
        } catch (DaoException e) {
            logger.error("Error was thrown in BillServiceImpl method delete: " + e);
            throw new ServiceException(e);
        }

    }

    @Override
    public void update(ClientDto clientDto) {

        ClientsEntity clientsEntity = DtoConverter.ClientDtoToClient(clientDto);
        try {
            clientDao.update(clientsEntity);
            logger.debug("Bill: " + clientsEntity + " successfully updated!");
        } catch (DaoException e) {
            logger.error("Error was thrown in BillServiceImpl method update: " + e);
            throw new ServiceException(e);
        }

    }

    @Override
    public List<ClientDto> getAll() {
        List<ClientDto> clientDtos = new ArrayList<>();
        try {
            List<ClientsEntity> clientEntities = clientDao.getAll();
            logger.debug("All client successfully found!");

            for (ClientsEntity clientsEntity : clientEntities) {
                ClientDto clientDto = DtoConverter.clientToClientDto(clientsEntity);
                clientDtos.add(clientDto);
            }
        } catch (DaoException e) {
            logger.error("Error was thrown in BillServiceImpl method getAll: " + e);
            throw new ServiceException(e);
        }
        return clientDtos;

    }

    @Override
    public ClientDto get(int id) {
        ClientDto clientDto;
        try {
            ClientsEntity clientsEntity = clientDao.getById(id);
            logger.debug("Bill by id: " + id + " successfully found!");
            clientDto = DtoConverter.clientToClientDto(clientsEntity);

        } catch (DaoException e) {
            logger.error("Error was thrown in BillServiceImpl method get: " + e);
            throw new ServiceException(e);
        }
        return clientDto;
    }

    @Override
    public int login(ClientDto clientDto) {
        ClientsEntity clientsEntity = clientDao.getByEmail(clientDto.getClientEmail());
        if (clientsEntity == null)
        {
            throw new NotFoundException("Client not found!");
        }
        else if (!clientsEntity.getClientPassword().equals(clientDto.getClientPassword()))
        {
            throw new NotFoundException("Password is incorrect!");
        }
        return clientsEntity.getId();
    }
}
