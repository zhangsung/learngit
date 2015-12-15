package com.nssoft.generator.model;

import javax.persistence.*;

@Table(name = "CHAJA_DT_REMITTANCEHANDLINGFEE")
public class ChajaDtRemittancehandlingfee {
    /**
     * 汇款编号
     */
    @Id
    private String remittance_id;

    /**
     * 订单号
     */
    @Id
    private String order_no;

    /**
     * 获取汇款编号
     *
     * @return remittance_id - 汇款编号
     */
    public String getRemittance_id() {
        return remittance_id;
    }

    /**
     * 设置汇款编号
     *
     * @param remittance_id 汇款编号
     */
    public void setRemittance_id(String remittance_id) {
        this.remittance_id = remittance_id;
    }

    /**
     * 获取订单号
     *
     * @return order_no - 订单号
     */
    public String getOrder_no() {
        return order_no;
    }

    /**
     * 设置订单号
     *
     * @param order_no 订单号
     */
    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }
}