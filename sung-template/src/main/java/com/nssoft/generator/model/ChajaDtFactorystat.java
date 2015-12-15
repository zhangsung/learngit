package com.nssoft.generator.model;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "CHAJA_DT_FACTORYSTAT")
public class ChajaDtFactorystat {
    /**
     * 工厂编号
     */
    @Id
    private String factory_id;

    /**
     * 应付款
     */
    private BigDecimal total_payable;

    /**
     * 实付款
     */
    private BigDecimal total_paid;

    /**
     * 是否结清
     */
    private String settle_yn;

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
     * 获取应付款
     *
     * @return total_payable - 应付款
     */
    public BigDecimal getTotal_payable() {
        return total_payable;
    }

    /**
     * 设置应付款
     *
     * @param total_payable 应付款
     */
    public void setTotal_payable(BigDecimal total_payable) {
        this.total_payable = total_payable;
    }

    /**
     * 获取实付款
     *
     * @return total_paid - 实付款
     */
    public BigDecimal getTotal_paid() {
        return total_paid;
    }

    /**
     * 设置实付款
     *
     * @param total_paid 实付款
     */
    public void setTotal_paid(BigDecimal total_paid) {
        this.total_paid = total_paid;
    }

    /**
     * 获取是否结清
     *
     * @return settle_yn - 是否结清
     */
    public String getSettle_yn() {
        return settle_yn;
    }

    /**
     * 设置是否结清
     *
     * @param settle_yn 是否结清
     */
    public void setSettle_yn(String settle_yn) {
        this.settle_yn = settle_yn;
    }
}