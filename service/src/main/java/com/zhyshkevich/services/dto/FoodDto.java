package com.zhyshkevich.services.dto;

/**
 * Created by Сергей on 31.05.2017.
 */
public class FoodDto extends BasicDto {

    private int id;
    private String foodName;
    private String foodDesc;
    private double foodPrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodDesc() {
        return foodDesc;
    }

    public void setFoodDesc(String foodDesc) {
        this.foodDesc = foodDesc;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(double foodPrice) {
        this.foodPrice = foodPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FoodDto foodDto = (FoodDto) o;

        if (id != foodDto.id) return false;
        if (Double.compare(foodDto.foodPrice, foodPrice) != 0) return false;
        if (foodName != null ? !foodName.equals(foodDto.foodName) : foodDto.foodName != null) return false;
        return foodDesc != null ? foodDesc.equals(foodDto.foodDesc) : foodDto.foodDesc == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (foodName != null ? foodName.hashCode() : 0);
        result = 31 * result + (foodDesc != null ? foodDesc.hashCode() : 0);
        temp = Double.doubleToLongBits(foodPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "FoodDto{" +
                "id=" + id +
                ", foodName='" + foodName + '\'' +
                ", foodDesc='" + foodDesc + '\'' +
                ", foodPrice=" + foodPrice +
                '}';
    }
}
