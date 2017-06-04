package com.zhyshkevich.controllers.usercontrollers;


import com.zhyshkevich.services.dto.FoodDto;
import com.zhyshkevich.services.interfaces.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Сергей on 01.06.2017.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    FoodService foodService;


    @RequestMapping(value = "food/{id}", method = RequestMethod.GET)
    public ResponseEntity<FoodDto> getFood(@PathVariable int id) {
        FoodDto user = foodService.get(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "food/all", method = RequestMethod.GET)
    public ResponseEntity<List<FoodDto>> getAllFood() {
        List<FoodDto> list = foodService.getAll();
        return new ResponseEntity<List<FoodDto>>(list, HttpStatus.OK);
    }
}
