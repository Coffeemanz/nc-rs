package com.zhyshkevich.dao.builders;

import com.zhyshkevich.entitites.BillsEntity;

/**
 * Created by Сергей on 01.06.2017.
 */
public class BillBuilder {

    private BillBuilder() {
    }

    private final BillsEntity billsEntity = new BillsEntity();

    public static class BillEntityBuilder {

        private BillsEntity billsEntity = new BillsEntity();

        public BillEntityBuilder id(int id)
        {
            this.billsEntity.setId(id);
            return this;
        }

        public BillEntityBuilder totalPrice(double totalPrice)
        {
            this.billsEntity.setTotalPrice(totalPrice);
            return this;
        }

        public BillEntityBuilder orderId(int orderId)
        {
            this.billsEntity.setOrder_id(orderId);
            return this;
        }

        public BillsEntity build()
        {
            return new BillBuilder().createBill(this);
        }


    }

    private BillsEntity createBill(BillEntityBuilder builder)
    {
        this.billsEntity.setId(builder.billsEntity.getId());
        this.billsEntity.setTotalPrice(builder.billsEntity.getTotalPrice());
        this.billsEntity.setOrder_id(builder.billsEntity.getOrder_id());
        return this.billsEntity;
    }
}
