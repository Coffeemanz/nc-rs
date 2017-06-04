package com.zhyshkevich.serviceTests;

import com.zhyshkevich.dao.implementations.ClientDaoImpl;
import com.zhyshkevich.dao.interfaces.BillDao;
import com.zhyshkevich.dao.interfaces.ClientDao;
import com.zhyshkevich.dao.interfaces.RoleDao;
import com.zhyshkevich.entitites.BillsEntity;
import com.zhyshkevich.entitites.ClientsEntity;
import com.zhyshkevich.entitites.OrdersEntity;
import com.zhyshkevich.entitites.RolesEntity;
import com.zhyshkevich.services.dto.*;
import com.zhyshkevich.services.interfaces.*;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Сергей on 31.05.2017.
 */


@Transactional
@Rollback(false)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/serviceContextTest.xml")
public class BillServiceImplTest {

    @Autowired
    private BillService billService;

    @Autowired
    OrderService orderService;

    @Autowired
    ClientService clientService;

    @Autowired
    RoleService roleService;

    @Autowired
    WaiterService waiterService;

    @Autowired
    RoleDao roleDao;

    @Autowired
    ClientDaoImpl clientDao;

    private BillDto billDto = new BillDto();
    private OrderDto orderDto = new OrderDto();
    private ClientDto clientDto = new ClientDto();
    private RoleDto roleDto = new RoleDto();
    private WaiterDto waiterDto = new WaiterDto();

    @Test
    public void save()
    {
        billDto.setOrderId(247);
        billDto.setTotalPrice(222d);

        billService.save(billDto);

    }

    @Test
    public void saveOrder()
    {
        orderDto.setWaiterId(1);
        orderDto.setClientId(165);
        orderDto.setFoodId(1);



        System.out.println("-----------------------------");
        System.out.println("Client id from dto in test");
        System.out.println(orderDto.getClientId());
        System.out.println("-----------------------------");

        orderService.save(orderDto);
    }


    @Test
    public void updateOrder()
    {
        System.out.println(orderService.getAll());
    }

    @Test
    public void findOrder()
    {
        OrderDto orderDto = orderService.get(247);
        System.out.println("----------------");
        System.out.println("Order dto from test");
        System.out.println(orderDto);
        System.out.println("----------------");
    }


    @Test
    public void findByEmail()
    {
        System.out.println("----------------");
        System.out.println(clientDao.getByEmail("kek"));
        System.out.println("----------------");
    }

    @Test
    public void saveClient()
    {
        clientDto.setClientName("TEST_ROLE");
        clientDto.setRoleId(3);

        clientService.save(clientDto);
    }

    @Test
    public void deleteClient()
    {
        //clientService.delete(178);
        clientDao.delete(178);
    }

    @Test
    public  void getClient()
    {
        ClientDto clientDto = clientService.get(165);

        //ClientsEntity clientsEntity = clientDao.getById(2);
        System.out.println("----------------");
        System.out.println(clientDto);
        //System.out.println(clientsEntity);

        System.out.println("----------------");
    }

    @Test
    public void saveRole()
    {
        roleDto.setName("TEST");

        roleService.save(roleDto);
    }

    @Test
    public  void getRole()
    {
        RoleDto roleDto = roleService.get(2);

        System.out.println(roleDto);
        RolesEntity rolesEntity = roleDao.getById(3);
        System.out.println("----------------");
        System.out.println("Loading set of clients with roles");
        System.out.println(rolesEntity.getClientsEntity());
        System.out.println("----------------");
    }

    @Test
    public  void deleteRole()
    {
        roleService.delete(6);
    }

    @Test
    public  void saveWaiter()
    {
        waiterDto.setWaiterName("TEST");
        waiterDto.setRoleId(3);

        waiterService.save(waiterDto);
    }



}
