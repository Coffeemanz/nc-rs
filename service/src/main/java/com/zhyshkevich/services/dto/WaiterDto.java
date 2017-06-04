package com.zhyshkevich.services.dto;

/**
 * Created by Сергей on 31.05.2017.
 */
public class WaiterDto extends BasicDto {

    private int id;
    private String waiterName;
    private String waiterEmail;
    private String waiterPassword;
    private int roleId;


    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWaiterName() {
        return waiterName;
    }

    public void setWaiterName(String waiterName) {
        this.waiterName = waiterName;
    }

    public String getWaiterEmail() {
        return waiterEmail;
    }

    public void setWaiterEmail(String waiterEmail) {
        this.waiterEmail = waiterEmail;
    }

    public String getWaiterPassword() {
        return waiterPassword;
    }

    public void setWaiterPassword(String waiterPassword) {
        this.waiterPassword = waiterPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WaiterDto waiterDto = (WaiterDto) o;

        if (id != waiterDto.id) return false;
        if (waiterName != null ? !waiterName.equals(waiterDto.waiterName) : waiterDto.waiterName != null) return false;
        if (waiterEmail != null ? !waiterEmail.equals(waiterDto.waiterEmail) : waiterDto.waiterEmail != null)
            return false;
        return waiterPassword != null ? waiterPassword.equals(waiterDto.waiterPassword) : waiterDto.waiterPassword == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (waiterName != null ? waiterName.hashCode() : 0);
        result = 31 * result + (waiterEmail != null ? waiterEmail.hashCode() : 0);
        result = 31 * result + (waiterPassword != null ? waiterPassword.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "WaiterDto{" +
                "id=" + id +
                ", waiterName='" + waiterName + '\'' +
                ", waiterEmail='" + waiterEmail + '\'' +
                ", waiterPassword='" + waiterPassword + '\'' +
                '}';
    }
}
