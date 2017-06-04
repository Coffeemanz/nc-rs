package com.zhyshkevich.controllers.usercontrollers;


import com.zhyshkevich.controllers.security.service.LoginService;
import com.zhyshkevich.services.dto.ClientDto;
import com.zhyshkevich.services.interfaces.ClientService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 * Created by Сергей on 04.06.2017.
 */

@RestController
@RequestMapping("/")
public class AllController {

    private final Logger logger = Logger.getLogger(AllController.class);

    @Autowired
    ClientService clientService;

    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<ClientDto> registerUser(@RequestBody ClientDto clientDto) {
        int id = clientService.save(clientDto);
        logger.debug("User was successfully registered");
        return new ResponseEntity<>(new ClientDto(id, HttpStatus.CREATED.toString()), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<ClientDto> loginUser(@RequestBody ClientDto clientDto) {
        System.out.println("------------");
        System.out.println(clientDto.getClientEmail());
        System.out.println(clientDto.getClientPassword());
        System.out.println("------------");
        int id = clientService.login(clientDto);
        loginService.authenticate(clientDto.getClientEmail(), clientDto.getClientPassword());
        logger.debug("User was successfully signed in!");
        return new ResponseEntity<>(new ClientDto(id, HttpStatus.OK.toString()), HttpStatus.OK);
    }
}
