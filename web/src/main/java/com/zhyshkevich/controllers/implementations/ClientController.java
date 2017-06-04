package com.zhyshkevich.controllers.implementations;


import com.zhyshkevich.controllers.absracts.CrudController;
import com.zhyshkevich.services.dto.ClientDto;
import com.zhyshkevich.services.dto.ClientDto;
import com.zhyshkevich.services.interfaces.BaseService;
import com.zhyshkevich.services.interfaces.BillService;
import com.zhyshkevich.services.interfaces.ClientService;
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
@RequestMapping("/clients")
public class ClientController extends CrudController<ClientDto>{

    private final Logger logger = Logger.getLogger(BillController.class);

    @Autowired
    ClientService clientService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Long> saveBill(@RequestBody ClientDto ClientDto) {
        return save(ClientDto);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity updateBill(@RequestBody ClientDto ClientDto) {
        return update(ClientDto);
    }

    @Override
    protected BaseService<ClientDto> getService() {
        return clientService;
    }
}
