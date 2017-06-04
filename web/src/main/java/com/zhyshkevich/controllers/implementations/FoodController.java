package com.zhyshkevich.controllers.implementations;



import com.zhyshkevich.controllers.absracts.CrudController;
import com.zhyshkevich.services.dto.FoodDto;
import com.zhyshkevich.services.dto.FoodDto;
import com.zhyshkevich.services.interfaces.BaseService;
import com.zhyshkevich.services.interfaces.BillService;
import com.zhyshkevich.services.interfaces.ClientService;
import com.zhyshkevich.services.interfaces.FoodService;
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
@RequestMapping("/foods")
public class FoodController extends CrudController<FoodDto>{

    private final Logger logger = Logger.getLogger(BillController.class);

    @Autowired
    FoodService foodService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Long> saveBill(@RequestBody FoodDto FoodDto) {
        return save(FoodDto);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity updateBill(@RequestBody FoodDto FoodDto) {
        return update(FoodDto);
    }

    @Override
    protected BaseService<FoodDto> getService() {
        return foodService;
    }
}
