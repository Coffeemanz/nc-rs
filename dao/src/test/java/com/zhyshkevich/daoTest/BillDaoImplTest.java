package com.zhyshkevich.daoTest;

import com.zhyshkevich.dao.builders.BillBuilder;
import com.zhyshkevich.dao.implementations.ClientDaoImpl;
import com.zhyshkevich.dao.interfaces.BillDao;
import com.zhyshkevich.dao.interfaces.ClientDao;
import com.zhyshkevich.entitites.BillsEntity;
import com.zhyshkevich.entitites.ClientsEntity;
import com.zhyshkevich.exceptions.DaoException;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Сергей on 30.05.2017.
 */

@Transactional
@Rollback(false)
@ContextConfiguration("/daoConrextTest.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class BillDaoImplTest {

    @Autowired
    private BillDao billDao;

    @Autowired
    private ClientDaoImpl clientDao;

    private BillsEntity billsEntity = new BillsEntity();
    private BillsEntity billsEntity1 = new BillsEntity();


    @Before
    public void setUp()
    {
        billsEntity = new BillBuilder
                .BillEntityBuilder()
                .totalPrice(345d)
                .orderId(247)
                .build();
    }

    @Test
    @Rollback
    public void save()
    {
        billsEntity.setOrder_id(247);
        billsEntity.setTotalPrice(7777f);

        int id = billDao.save(billsEntity);
        billsEntity1 = billDao.getById(id);
        Assert.assertEquals("testSave() method failed: ", billsEntity, billsEntity1);

    }

    @Test
    @Rollback
    public void delete()
    {

        int id =billDao.save(billsEntity);

        billDao.delete(id);

        billsEntity1 = billDao.getById(id);
        Assert.assertNull("testDelete() method failed: ", billsEntity1);

    }

//    @Ignore
//    @Test
//    public void findByEmail()
//    {
//        clientsEntity = clientDao.getByEmail("ts");
//        System.out.println(clientsEntity);
//    }

    @Test
    @Rollback
    public void update()
    {

        int id = billDao.save(billsEntity);

        billsEntity.setTotalPrice(8888f);

        billDao.save(billsEntity);

        billsEntity1 = billDao.getById(id);

       // billDao.update(billsEntity);

        Assert.assertEquals("testUpdate() method failed: ", billsEntity, billsEntity1);
    }

    @Test
    @Rollback
    public void getById()
    {

        int id = billDao.save(billsEntity);

        billsEntity1 = billDao.getById(id);
        Assert.assertEquals("testGetById() method failed: ", billsEntity, billsEntity1);
    }

    @Test
    @Rollback
    public void getAll()
    {
        List<BillsEntity> list = billDao.getAll();
        Assert.assertTrue("testGetAll() method failed: ",list.size()>=2);
    }



}
