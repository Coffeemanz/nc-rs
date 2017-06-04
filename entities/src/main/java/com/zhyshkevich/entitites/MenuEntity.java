package com.zhyshkevich.entitites;

import javax.persistence.*;
import java.awt.*;

/**
 * Created by Сергей on 03.05.2017.
 */
@Entity
@Table(name = "menu", schema = "restraunt_nc", catalog = "restraunt_nc")
public class MenuEntity extends BaseEntity {
//    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
//    private int id;
    private String menu_name;

//    @Id
//    @Column(name = "id", nullable = false)
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public MenuEntity()
    {
        super();
    }

    @Basic
    @Column(name = "menu_name", nullable = true, length = 45)
    public String getMenuName() {
        return menu_name;
    }

    public void setMenuName(String menu_name) {
        this.menu_name = menu_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        MenuEntity that = (MenuEntity) o;

        return menu_name != null ? menu_name.equals(that.menu_name) : that.menu_name == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (menu_name != null ? menu_name.hashCode() : 0);
        return result;
    }
}
