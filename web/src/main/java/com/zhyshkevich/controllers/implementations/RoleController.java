package com.zhyshkevich.controllers.implementations;

import com.zhyshkevich.controllers.absracts.CrudController;
import com.zhyshkevich.services.dto.RoleDto;
import com.zhyshkevich.services.dto.RoleDto;
import com.zhyshkevich.services.interfaces.BaseService;
import com.zhyshkevich.services.interfaces.BillService;
import com.zhyshkevich.services.interfaces.ClientService;
import com.zhyshkevich.services.interfaces.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.apache.log4j.Logger;

/**
 * Created by Сергей on 01.06.2017.
 */

@RestController
@RequestMapping("/roles")
public class RoleController extends CrudController<RoleDto>{

    private final Logger logger = Logger.getLogger(BillController.class);

    @Autowired
    RoleService RoleService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Long> saveBill(@RequestBody RoleDto RoleDto) {
        return save(RoleDto);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity updateBill(@RequestBody RoleDto RoleDto) {
        return update(RoleDto);
    }

    @Override
    protected BaseService<RoleDto> getService() {
        return RoleService;
    }
}
