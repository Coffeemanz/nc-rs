package com.zhyshkevich.services.dto;

/**
 * Created by Сергей on 31.05.2017.
 */
public class MenuDto extends BasicDto {

    private int id;
    private String menuName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MenuDto menuDto = (MenuDto) o;

        if (id != menuDto.id) return false;
        return menuName != null ? menuName.equals(menuDto.menuName) : menuDto.menuName == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (menuName != null ? menuName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MenuDto{" +
                "id=" + id +
                ", menuName='" + menuName + '\'' +
                '}';
    }
}
