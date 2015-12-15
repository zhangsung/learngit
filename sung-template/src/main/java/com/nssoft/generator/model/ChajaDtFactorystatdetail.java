package com.nssoft.generator.model;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "CHAJA_DT_FACTORYSTATDETAIL")
public class ChajaDtFactorystatdetail {
    /**
     * 工厂编号
     */
    @Id
    private String factory_id;

    /**
     * 出货编号
     */
    @Id
    private String shipment_no;

    /**
     * 应付款
     */
    private BigDecimal payable;

    /**
     * 实付款
     */
    private BigDecimal paid;

    /**
     * 获取工厂编号
     *
     * @return factory_id - 工厂编号
     */
    public String getFactory_id() {
        return factory_id;
    }

    /**
     * 设置工厂编号
     *
     * @param factory_id 工厂编号
     */
    public void setFactory_id(String factory_id) {
        this.factory_id = factory_id;
    }

    /**
     * 获取出货编号
     *
     * @return shipment_no - 出货编号
     */
    public String getShipment_no() {
        return shipment_no;
    }

    /**
     * 设置出货编号
     *
     * @param shipment_no 出货编号
     */
    public void setShipment_no(String shipment_no) {
        this.shipment_no = shipment_no;
    }

    /**
     * 获取应付款
     *
     * @return payable - 应付款
     */
    public BigDecimal getPayable() {
        return payable;
    }

    /**
     * 设置应付款
     *
     * @param payable 应付款
     */
    public void setPayable(BigDecimal payable) {
        this.payable = payable;
    }

    /**
     * 获取实付款
     *
     * @return paid - 实付款
     */
    public BigDecimal getPaid() {
        return paid;
    }

    /**
     * 设置实付款
     *
     * @param paid 实付款
     */
    public void setPaid(BigDecimal paid) {
        this.paid = paid;
    }
}