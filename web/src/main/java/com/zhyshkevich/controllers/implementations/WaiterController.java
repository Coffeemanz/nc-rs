package com.zhyshkevich.controllers.implementations;

import com.zhyshkevich.controllers.absracts.CrudController;
import com.zhyshkevich.services.dto.WaiterDto;
import com.zhyshkevich.services.dto.WaiterDto;
import com.zhyshkevich.services.interfaces.BaseService;
import com.zhyshkevich.services.interfaces.BillService;
import com.zhyshkevich.services.interfaces.ClientService;
import com.zhyshkevich.services.interfaces.WaiterService;
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
@RequestMapping("/waiters")
public class WaiterController extends CrudController<WaiterDto>{

    private final Logger logger = Logger.getLogger(BillController.class);

    @Autowired
    WaiterService waiterService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Long> saveBill(@RequestBody WaiterDto WaiterDto) {
        return save(WaiterDto);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity updateBill(@RequestBody WaiterDto WaiterDto) {
        return update(WaiterDto);
    }

    @Override
    protected BaseService<WaiterDto> getService() {
        return waiterService;
    }
}
