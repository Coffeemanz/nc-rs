package com.zhyshkevich.entitites;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Сергей on 03.05.2017.
 */
@Entity
@Table(name = "food", schema = "restraunt_nc" , catalog = "restraunt_nc")
public class FoodEntity extends BaseEntity{
//    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
//    private int id;
    private String food_name;
    private String food_desc;
    private double food_price;

//    @Id
//    @Column(name = "id", nullable = false)
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

//    @Id
//    private int id;
//    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @Column(name = "id", nullable = false)
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }


    public FoodEntity()
    {
        super();
    }

    @Basic
    @Column(name = "food_name", nullable = false, length = 45)
    public String getFoodName() {
        return food_name;
    }

    public void setFoodName(String food_name) {
        this.food_name = food_name;
    }

    @Basic
    @Column(name = "food_desc", nullable = true, length = 45)
    public String getFoodDesc() {
        return food_desc;
    }

    public void setFoodDesc(String food_desc) {
        this.food_desc = food_desc;
    }

    @Basic
    @Column(name = "food_price", nullable = false, precision = 0)
    public double getFoodPrice() {
        return food_price;
    }

    public void setFoodPrice(double food_price) {
        this.food_price = food_price;
    }

    @OneToMany(mappedBy = "food_id", cascade = CascadeType.ALL, fetch = FetchType.LAZY) //was LAZY
    private Set<OrdersEntity> ordersEntity = new HashSet<>();

    public Set<OrdersEntity> getOrdersEntity() {
        return ordersEntity;
    }

    public void setOrdersEntity(Set<OrdersEntity> ordersEntity) {
        this.ordersEntity = ordersEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        FoodEntity that = (FoodEntity) o;

        if (Double.compare(that.food_price, food_price) != 0) return false;
        if (food_name != null ? !food_name.equals(that.food_name) : that.food_name != null) return false;
        return food_desc != null ? food_desc.equals(that.food_desc) : that.food_desc == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + (food_name != null ? food_name.hashCode() : 0);
        result = 31 * result + (food_desc != null ? food_desc.hashCode() : 0);
        temp = Double.doubleToLongBits(food_price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
