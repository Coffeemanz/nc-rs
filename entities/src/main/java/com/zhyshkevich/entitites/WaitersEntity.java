package com.zhyshkevich.entitites;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Сергей on 03.05.2017.
 */
@Entity
@Table(name = "waiters", schema = "restraunt_nc", catalog = "restraunt_nc")
public class WaitersEntity extends BaseEntity{
//    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
//    private int id;
    private String waiter_name;
    private String waiter_email;
    private String waiter_password;
    //private RolesEntity role_id;

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

    @Basic
    @Column(name = "waiter_name", nullable = true, length = 45)
    public String getWaiterName() {
        return waiter_name;
    }

    public void setWaiterName(String waiter_name) {
        this.waiter_name = waiter_name;
    }

    @Basic
    @Column(name = "waiter_email", nullable = true, length = 45)
    public String getWaiterEmail() {
        return waiter_email;
    }

    public void setWaiterEmail(String waiter_email) {
        this.waiter_email = waiter_email;
    }

    @Basic
    @Column(name = "waiter_password", nullable = true, length = 45)
    public String getWaiterPassword() {
        return waiter_password;
    }

    public void setWaiterPassword(String waiter_password) {
        this.waiter_password = waiter_password;
    }

    @OneToMany(mappedBy = "waiter_id", cascade = CascadeType.ALL, fetch = FetchType.LAZY) //was LAZY
    private Set<OrdersEntity> ordersEntity = new HashSet<>();

    public Set<OrdersEntity> getOrdersEntity() {
        return ordersEntity;
    }

    public void setOrdersEntity(Set<OrdersEntity> ordersEntity) {
        this.ordersEntity = ordersEntity;
    }

//    @ManyToOne
//    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
//    public  RolesEntity getRole_id() {return role_id;}
//
//    public void setRole_id(RolesEntity role_id) {this.role_id = role_id;}

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
    private RolesEntity role_id;
    public  RolesEntity getRole_id() {return role_id;}

    public void setRole_id(RolesEntity role_id) {this.role_id = role_id;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        WaitersEntity that = (WaitersEntity) o;

        if (waiter_name != null ? !waiter_name.equals(that.waiter_name) : that.waiter_name != null) return false;
        if (waiter_email != null ? !waiter_email.equals(that.waiter_email) : that.waiter_email != null) return false;
        return waiter_password != null ? waiter_password.equals(that.waiter_password) : that.waiter_password == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (waiter_name != null ? waiter_name.hashCode() : 0);
        result = 31 * result + (waiter_email != null ? waiter_email.hashCode() : 0);
        result = 31 * result + (waiter_password != null ? waiter_password.hashCode() : 0);
        return result;
    }
}
