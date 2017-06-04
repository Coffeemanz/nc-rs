package com.zhyshkevich.controllers.implementations;

import com.zhyshkevich.controllers.absracts.CrudController;
import com.zhyshkevich.services.dto.BillDto;
import com.zhyshkevich.services.interfaces.BaseService;
import com.zhyshkevich.services.interfaces.BillService;
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
@RequestMapping("/bills")
public class BillController extends CrudController<BillDto> {

    private final Logger logger = Logger.getLogger(BillController.class);

    @Autowired
    BillService billService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Long> saveBill(@RequestBody BillDto billDto) {
        return save(billDto);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity updateBill(@RequestBody BillDto billDto) {
        return update(billDto);
    }

    @Override
    protected BaseService<BillDto> getService() {
        return billService;
    }

}
