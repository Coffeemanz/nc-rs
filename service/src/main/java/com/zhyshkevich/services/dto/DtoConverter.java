package com.zhyshkevich.services.dto;

import com.zhyshkevich.dao.interfaces.WaiterDao;
import com.zhyshkevich.entitites.*;

/**
 * Created by Сергей on 31.05.2017.
 */
public class DtoConverter {

    public static BillDto billToBillDto(BillsEntity billsEntity)
    {
        BillDto billDto = null;
        if (billsEntity != null)
        {
            billDto = new BillDto();
            billDto.setId(billsEntity.getId());
            billDto.setOrderId(billsEntity.getOrder_id());
            billDto.setTotalPrice(billsEntity.getTotalPrice());
        }
        return billDto;
    }

    public static RoleDto roleToRoleDto(RolesEntity rolesEntity)
    {
        RoleDto roleDto = null;
        if (rolesEntity != null)
        {
            roleDto = new RoleDto();
            roleDto.setId(rolesEntity.getId());
            roleDto.setName(rolesEntity.getName());
        }
        return roleDto;
    }

    public static ClientDto clientToClientDto(ClientsEntity clientsEntity)
    {
        ClientDto clientDto = null;
        if (clientsEntity != null)
        {
            clientDto = new ClientDto();
            clientDto.setId(clientsEntity.getId());
            clientDto.setClientCash(clientsEntity.getClientCash());
            clientDto.setClientEmail(clientsEntity.getClientEmail());
            clientDto.setClientName(clientsEntity.getClientName());
            clientDto.setClientPassword(clientsEntity.getClientPassword());
            clientDto.setPaid(clientsEntity.getPaid());
            clientDto.setRoleId(clientsEntity.getRole_id().getId());
        }
        return clientDto;
    }

    public static FoodDto foodToFoodDto(FoodEntity foodEntity)
    {
        FoodDto foodDto = null;
        if (foodEntity != null)
        {
            foodDto = new FoodDto();
            foodDto.setId(foodEntity.getId());
            foodDto.setFoodDesc(foodEntity.getFoodDesc());
            foodDto.setFoodName(foodEntity.getFoodName());
            foodDto.setFoodPrice(foodEntity.getFoodPrice());
        }
        return foodDto;
    }

    public static MenuDto menuToMenuDto(MenuEntity menuEntity)
    {
        MenuDto menuDto = null;
        if (menuEntity != null)
        {
            menuDto = new MenuDto();
            menuDto.setId(menuEntity.getId());
            menuDto.setMenuName(menuEntity.getMenuName());
        }
        return menuDto;
    }

    public  static OrderDto orderToOrderDto(OrdersEntity ordersEntity)
    {
        OrderDto orderDto = null;
        if (ordersEntity != null)
        {
            orderDto = new OrderDto();
            orderDto.setId(ordersEntity.getId());
            orderDto.setClientId(ordersEntity.getClient().getId());
            orderDto.setFoodId(ordersEntity.getFood().getId());
            orderDto.setWaiterId(ordersEntity.getWaiter().getId());
        }

        return orderDto;
    }

    public static WaiterDto waiterToWaiterDto(WaitersEntity waitersEntity)
    {
        WaiterDto waiterDto = null;
        if (waitersEntity != null)
        {
            waiterDto = new WaiterDto();
            waiterDto.setId(waitersEntity.getId());
            waiterDto.setWaiterEmail(waitersEntity.getWaiterEmail());
            waiterDto.setWaiterName(waitersEntity.getWaiterName());
            waiterDto.setWaiterPassword(waitersEntity.getWaiterPassword());
            waiterDto.setRoleId(waitersEntity.getRole_id().getId());
        }

        return waiterDto;
    }

    public static BillsEntity BillDtoToBill(BillDto billDto)
    {
        BillsEntity billsEntity = new BillsEntity();
        billsEntity.setId(billDto.getId());
        billsEntity.setOrder_id(billDto.getOrderId());
        billsEntity.setTotalPrice(billDto.getTotalPrice());
        return billsEntity;
    }

    public static RolesEntity RoleDtotoRole(RoleDto roleDto)
    {
        RolesEntity rolesEntity = new RolesEntity();
        rolesEntity.setId(roleDto.getId());
        rolesEntity.setName(roleDto.getName());

        return rolesEntity;
    }

    public static ClientsEntity ClientDtoToClient(ClientDto clientDto)
    {
        ClientsEntity clientsEntity = new ClientsEntity();
        clientsEntity.setId(clientDto.getId());
        clientsEntity.setClientCash(clientDto.getClientCash());
        clientsEntity.setClientPassword(clientDto.getClientPassword());
        clientsEntity.setClientName(clientDto.getClientName());
        clientsEntity.setClientEmail(clientDto.getClientEmail());

        RolesEntity rolesEntity = new RolesEntity();
        rolesEntity.setId(clientDto.getRoleId());
        clientsEntity.setRole_id(rolesEntity);
        return clientsEntity;
    }

    public static  FoodEntity FoodDtoToFood(FoodDto foodDto)
    {
        FoodEntity foodEntity = new FoodEntity();
        foodEntity.setId(foodDto.getId());
        foodEntity.setFoodDesc(foodDto.getFoodDesc());
        foodEntity.setFoodName(foodDto.getFoodName());
        foodEntity.setFoodPrice(foodDto.getFoodPrice());
        return foodEntity;
    }

    public static  MenuEntity MenuDtoToMenu(MenuDto menuDto)
    {
        MenuEntity menuEntity = new MenuEntity();
        menuEntity.setId(menuDto.getId());
        menuEntity.setMenuName(menuDto.getMenuName());
        return menuEntity;
    }

    public  static  OrdersEntity OrderDtoToOrder (OrderDto orderDto)
    {
        OrdersEntity ordersEntity = new OrdersEntity();
        ordersEntity.setId(orderDto.getId());

        WaitersEntity waitersEntity = new WaitersEntity();
        waitersEntity.setId(orderDto.getWaiterId());
        ordersEntity.setWaiter(waitersEntity);

        ClientsEntity clientsEntity = new ClientsEntity();
        clientsEntity.setId(orderDto.getClientId());
        ordersEntity.setClient(clientsEntity);

        FoodEntity foodEntity = new FoodEntity();
        foodEntity.setId(orderDto.getFoodId());
        ordersEntity.setFood(foodEntity);

        return ordersEntity;
    }

    public static WaitersEntity WaiterDtoToWaiter(WaiterDto waiterDto)
    {
        WaitersEntity waitersEntity = new WaitersEntity();
        waitersEntity.setId(waiterDto.getId());
        waitersEntity.setWaiterEmail(waiterDto.getWaiterEmail());
        waitersEntity.setWaiterName(waiterDto.getWaiterName());
        waitersEntity.setWaiterPassword(waiterDto.getWaiterPassword());


        RolesEntity rolesEntity = new RolesEntity();
        rolesEntity.setId(waiterDto.getRoleId());
        waitersEntity.setRole_id(rolesEntity);
        return waitersEntity;
    }


}
