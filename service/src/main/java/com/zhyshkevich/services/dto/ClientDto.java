package com.zhyshkevich.services.dto;

/**
 * Created by Сергей on 31.05.2017.
 */
public class ClientDto extends BasicDto {

    private int id;
    private String clientName;
    private String clientEmail;
    private String clientPassword;
    private Double clientCash;
    private Byte paid;
    private int roleId;

    public ClientDto(){}

    public ClientDto(int id, String httpStatus)
    {
        super(id, httpStatus);
    }


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

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getClientPassword() {
        return clientPassword;
    }

    public void setClientPassword(String clientPassword) {
        this.clientPassword = clientPassword;
    }

    public Double getClientCash() {
        return clientCash;
    }

    public void setClientCash(Double clientCash) {
        this.clientCash = clientCash;
    }

    public Byte getPaid() {
        return paid;
    }

    public void setPaid(Byte paid) {
        this.paid = paid;
    }

    @Override
    public String toString() {
        return "ClientDto{" +
                "id=" + id +
                ", clientName='" + clientName + '\'' +
                ", clientEmail='" + clientEmail + '\'' +
                ", clientPassword='" + clientPassword + '\'' +
                ", clientCash=" + clientCash +
                ", paid=" + paid +
                ", roleID=" + roleId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientDto clientDto = (ClientDto) o;

        if (id != clientDto.id) return false;
        if (clientName != null ? !clientName.equals(clientDto.clientName) : clientDto.clientName != null) return false;
        if (clientEmail != null ? !clientEmail.equals(clientDto.clientEmail) : clientDto.clientEmail != null)
            return false;
        if (clientPassword != null ? !clientPassword.equals(clientDto.clientPassword) : clientDto.clientPassword != null)
            return false;
        if (clientCash != null ? !clientCash.equals(clientDto.clientCash) : clientDto.clientCash != null) return false;
        return paid != null ? paid.equals(clientDto.paid) : clientDto.paid == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (clientName != null ? clientName.hashCode() : 0);
        result = 31 * result + (clientEmail != null ? clientEmail.hashCode() : 0);
        result = 31 * result + (clientPassword != null ? clientPassword.hashCode() : 0);
        result = 31 * result + (clientCash != null ? clientCash.hashCode() : 0);
        result = 31 * result + (paid != null ? paid.hashCode() : 0);
        return result;
    }
}
