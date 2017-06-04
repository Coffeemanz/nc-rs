package com.zhyshkevich.entitites;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;

/**
 * Created by Сергей on 03.05.2017.
 */
@Entity
@Table(name = "clients", schema = "restraunt_nc", catalog = "restraunt_nc")
public class ClientsEntity extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
//    private int id;








    public ClientsEntity()
    {
        super();
    }

    public ClientsEntity(ClientsEntity clientsEntity)
    {
        super(clientsEntity.getId());
        this.client_name = clientsEntity.getClientName();
        this.client_email = clientsEntity.getClientEmail();
        this.client_password = clientsEntity.getClientPassword();
        this.client_cash = clientsEntity.getClientCash();
        this.paid = clientsEntity.getPaid();
        this.role_id = clientsEntity.getRole_id();
    }


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

        ClientsEntity that = (ClientsEntity) o;

        if (client_name != null ? !client_name.equals(that.client_name) : that.client_name != null) return false;
        if (client_email != null ? !client_email.equals(that.client_email) : that.client_email != null) return false;
        if (client_password != null ? !client_password.equals(that.client_password) : that.client_password != null)
            return false;
        if (client_cash != null ? !client_cash.equals(that.client_cash) : that.client_cash != null) return false;
        return paid != null ? paid.equals(that.paid) : that.paid == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (client_name != null ? client_name.hashCode() : 0);
        result = 31 * result + (client_email != null ? client_email.hashCode() : 0);
        result = 31 * result + (client_password != null ? client_password.hashCode() : 0);
        result = 31 * result + (client_cash != null ? client_cash.hashCode() : 0);
        result = 31 * result + (paid != null ? paid.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "client_name", nullable = true, length = 45)
    private String client_name;
    public String getClientName() {
        return client_name;
    }

    public void setClientName(String client_name) {
        this.client_name = client_name;
    }

    @Basic
    @Column(name = "client_email", nullable = true, length = 45)
    private String client_email;
    public String getClientEmail() {
        return client_email;
    }

    public void setClientEmail(String client_email) {
        this.client_email = client_email;
    }

    @Basic
    @Column(name = "client_password", nullable = true, length = 45)
    private String client_password;
    public String getClientPassword() {
        return client_password;
    }

    public void setClientPassword(String client_password) {
        this.client_password = client_password;
    }

    @Basic
    @Column(name = "client_cash", nullable = true, precision = 0)
    private Double client_cash;
    public Double getClientCash() {
        return client_cash;
    }

    public void setClientCash(Double client_cash) {
        this.client_cash = client_cash;
    }

    @Basic
    @Column(name = "paid", nullable = true)
    private Byte paid;
    public Byte getPaid() {
        return paid;
    }

    public void setPaid(Byte paid) {
        this.paid = paid;
    }


    @OneToMany(mappedBy = "client_id", cascade = CascadeType.ALL, fetch = FetchType.LAZY) //was LAZY
    private Set<OrdersEntity> ordersEntity = new HashSet<>();

    public Set<OrdersEntity> getOrdersEntity() {
        return ordersEntity;
    }

    public void setOrdersEntity(Set<OrdersEntity> ordersEntity) {
        this.ordersEntity = ordersEntity;
    }

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RolesEntity role_id;
    public  RolesEntity getRole_id() {return role_id;}

    public void setRole_id(RolesEntity role_id) {this.role_id = role_id;}

    @Override
    public String toString() {
        return "ClientsEntity{" +
                "client_name='" + client_name + '\'' +
                ", client_email='" + client_email + '\'' +
                ", client_password='" + client_password + '\'' +
                ", client_cash=" + client_cash +
                ", paid=" + paid +
                ", role_id=" + role_id +
                '}';
    }
}
