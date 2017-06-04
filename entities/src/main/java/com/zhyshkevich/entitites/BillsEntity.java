package com.zhyshkevich.entitites;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

/**
 * Created by Сергей on 03.05.2017.
 */
@Entity
@Table(name = "bills", schema = "restraunt_nc", catalog = "restraunt_nc")
public class BillsEntity extends BaseEntity {
//    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
//    private int id;
    private int order_id;
    private double total_price;

//    @Id
//    @Column(name = "id", nullable = false)
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public BillsEntity()
    {
        super();
    }

    @Basic
    @Column(name = "order_id", nullable = false, precision = 0)
    public int getOrder_id() {return order_id;}

    public void setOrder_id(int order_id) {this.order_id = order_id;}

    @Basic
    @ColumnDefault("0f")
    @Column(name = "total_price", nullable = false, precision = 0)
    public double getTotalPrice() {
        return total_price;
    }

    public void setTotalPrice(double total_price) {
        this.total_price = total_price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        BillsEntity that = (BillsEntity) o;

        if (order_id != that.order_id) return false;
        return Double.compare(that.total_price, total_price) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + order_id;
        temp = Double.doubleToLongBits(total_price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "BillsEntity{" +
                "order_id=" + order_id +
                ", total_price=" + total_price +
                '}';
    }
}
