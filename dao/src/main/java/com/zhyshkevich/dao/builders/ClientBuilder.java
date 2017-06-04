package com.zhyshkevich.dao.builders;

import com.zhyshkevich.entitites.ClientsEntity;

/**
 * Created by Сергей on 01.06.2017.
 */
public class ClientBuilder {

    private ClientBuilder(){}

    private final ClientsEntity clientsEntity = new ClientsEntity();

    public static class ClientEntityBuilder
    {
        private ClientsEntity clientsEntity = new ClientsEntity();

        public ClientEntityBuilder id(int id) {
            this.clientsEntity.setId(id);
            return this;
        }

        public ClientEntityBuilder name(String name) {
            this.clientsEntity.setClientName(name);
            return this;
        }

        public ClientEntityBuilder email(String email) {
            this.clientsEntity.setClientEmail(email);
            return this;
        }

        public ClientEntityBuilder password(String password) {
            this.clientsEntity.setClientPassword(password);
            return this;
        }

        public ClientEntityBuilder cash(Double cash) {
            this.clientsEntity.setClientCash(cash);
            return this;
        }

        public ClientEntityBuilder paid(Byte paid) {
            this.clientsEntity.setPaid(paid);
            return this;
        }



    }
}
