package com.zhyshkevich.controllers.implementations;

import com.zhyshkevich.controllers.absracts.CrudController;
import com.zhyshkevich.services.dto.MenuDto;
import com.zhyshkevich.services.dto.MenuDto;
import com.zhyshkevich.services.interfaces.BaseService;
import com.zhyshkevich.services.interfaces.BillService;
import com.zhyshkevich.services.interfaces.ClientService;
import com.zhyshkevich.services.interfaces.MenuService;
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
@RequestMapping("/menus")
public class MenuController extends CrudController<MenuDto>{

    private final Logger logger = Logger.getLogger(BillController.class);

    @Autowired
    MenuService menuService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Long> saveBill(@RequestBody MenuDto MenuDto) {
        return save(MenuDto);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity updateBill(@RequestBody MenuDto MenuDto) {
        return update(MenuDto);
    }

    @Override
    protected BaseService<MenuDto> getService() {
        return menuService;
    }
}
