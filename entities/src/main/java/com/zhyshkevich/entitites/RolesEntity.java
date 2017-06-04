package com.zhyshkevich.entitites;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Сергей on 01.06.2017.
 */
@Entity
@Table(name = "roles", schema = "restraunt_nc", catalog = "restraunt_nc")
public class RolesEntity  extends  BaseEntity implements Serializable{
   // private int id;


//    @Id
//    private int id;
//    @OneToMany(mappedBy = "clients", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @Column(name = "id", nullable = false)
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }



    @Basic
    @Column(name = "name", nullable = true, length = 45)
    private String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "role_id", cascade = CascadeType.ALL, fetch = FetchType.EAGER) //was LAZY
    private Set<ClientsEntity> clientssEntity = new HashSet<>();

    public Set<ClientsEntity> getClientsEntity() {
        return clientssEntity;
    }

    @OneToMany(mappedBy = "role_id", cascade = CascadeType.ALL, fetch = FetchType.LAZY) //was LAZY
    private Set<WaitersEntity> waitersEntity = new HashSet<>();

    public Set<WaitersEntity> getWaitersEntity() {
        return waitersEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        RolesEntity that = (RolesEntity) o;

        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
