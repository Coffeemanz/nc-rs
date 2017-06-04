package com.zhyshkevich.controllers.implementations;


import com.zhyshkevich.controllers.absracts.CrudController;
import com.zhyshkevich.services.dto.OrderDto;
import com.zhyshkevich.services.dto.OrderDto;
import com.zhyshkevich.services.interfaces.BaseService;
import com.zhyshkevich.services.interfaces.BillService;
import com.zhyshkevich.services.interfaces.ClientService;
import com.zhyshkevich.services.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.apache.log4j.Logger;

/**
 * Created by Сергей on 31.05.2017.
 */

@RestController
@RequestMapping("/orders")
public class OrderController extends CrudController<OrderDto>{

    private final Logger logger = Logger.getLogger(BillController.class);

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Long> saveBill(@RequestBody OrderDto OrderDto) {
        return save(OrderDto);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity updateBill(@RequestBody OrderDto OrderDto) {
        return update(OrderDto);
    }

    @Override
    protected BaseService<OrderDto> getService() {
        return orderService;
    }
}
