package com.nssoft.generator.model;

import javax.persistence.*;

@Table(name = "CHAJA_DT_CONTRACTDETAIL")
public class ChajaDtContractdetail {
    /**
     * 合同号
     */
    @Id
    private String contract_no;

    /**
     * 订单号
     */
    @Id
    private String order_no;

    /**
     * 获取合同号
     *
     * @return contract_no - 合同号
     */
    public String getContract_no() {
        return contract_no;
    }

    /**
     * 设置合同号
     *
     * @param contract_no 合同号
     */
    public void setContract_no(String contract_no) {
        this.contract_no = contract_no;
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