package com.zhyshkevich.entitites;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Сергей on 03.05.2017.
 */
@SuppressWarnings("JpaAttributeTypeInspection")
@Entity
@Table(name = "orders", schema = "restraunt_nc", catalog = "restraunt_nc")
public class OrdersEntity extends BaseEntity{
//    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
//    private int id;




//    @Id
//    @Column(name = "id", nullable = false)
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        OrdersEntity that = (OrdersEntity) o;

        if (waiter_id != null ? !waiter_id.equals(that.waiter_id) : that.waiter_id != null)
            return false;
        if (client_id != null ? !client_id.equals(that.client_id) : that.client_id != null)
            return false;
        return food_id != null ? food_id.equals(that.food_id) : that.food_id == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (waiter_id != null ? waiter_id.hashCode() : 0);
        result = 31 * result + (client_id != null ? client_id.hashCode() : 0);
        result = 31 * result + (food_id != null ? food_id.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false)
    private ClientsEntity client_id;
    public ClientsEntity getClient() {
        return client_id;
    }

    public void setClient(ClientsEntity client_id) {
        this.client_id = client_id;
    }

    @ManyToOne
    @JoinColumn(name = "waiter_id", referencedColumnName = "id", nullable = false)
    private WaitersEntity waiter_id;
    public WaitersEntity getWaiter() {
        return waiter_id;
    }

    public void setWaiter(WaitersEntity waiter_id) {
        this.waiter_id = waiter_id;
    }



    @ManyToOne
    @JoinColumn(name = "food_id", referencedColumnName = "id", nullable = false)
    private FoodEntity food_id;
    public FoodEntity getFood() {
        return food_id;
    }

    public void setFood(FoodEntity food_id) {
        this.food_id = food_id;
    }
}
