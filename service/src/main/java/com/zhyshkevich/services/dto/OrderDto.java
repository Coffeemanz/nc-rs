package com.zhyshkevich.services.dto;

/**
 * Created by Сергей on 31.05.2017.
 */
public class OrderDto extends  BasicDto{
    private int id;
    private int waiterId;
    private int clientId;
    private int foodId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWaiterId() {
        return waiterId;
    }

    public void setWaiterId(int waiterId) {
        this.waiterId = waiterId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderDto orderDto = (OrderDto) o;

        if (id != orderDto.id) return false;
        if (waiterId != orderDto.waiterId) return false;
        if (clientId != orderDto.clientId) return false;
        return foodId == orderDto.foodId;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + waiterId;
        result = 31 * result + clientId;
        result = 31 * result + foodId;
        return result;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "id=" + id +
                ", waiterId=" + waiterId +
                ", clientId=" + clientId +
                ", foodId=" + foodId +
                '}';
    }
}
