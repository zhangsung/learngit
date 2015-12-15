package com.nssoft.generator.model;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "CHAJA_DT_MOULDCONTRACTITEMS")
public class ChajaDtMouldcontractitems {
    /**
     * 合同号
     */
    @Id
    private String contract_no;

    /**
     * 款号
     */
    @Id
    private String item_no;

    /**
     * 工厂款号
     */
    private String item_no_factory;

    /**
     * 备注
     */
    private String exp;

    /**
     * 工厂报价
     */
    private BigDecimal unitprice;

    /**
     * 报价单位
     */
    private String unitprice_unit;

    /**
     * 条款
     */
    private String term;

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
     * 获取款号
     *
     * @return item_no - 款号
     */
    public String getItem_no() {
        return item_no;
    }

    /**
     * 设置款号
     *
     * @param item_no 款号
     */
    public void setItem_no(String item_no) {
        this.item_no = item_no;
    }

    /**
     * 获取工厂款号
     *
     * @return item_no_factory - 工厂款号
     */
    public String getItem_no_factory() {
        return item_no_factory;
    }

    /**
     * 设置工厂款号
     *
     * @param item_no_factory 工厂款号
     */
    public void setItem_no_factory(String item_no_factory) {
        this.item_no_factory = item_no_factory;
    }

    /**
     * 获取备注
     *
     * @return exp - 备注
     */
    public String getExp() {
        return exp;
    }

    /**
     * 设置备注
     *
     * @param exp 备注
     */
    public void setExp(String exp) {
        this.exp = exp;
    }

    /**
     * 获取工厂报价
     *
     * @return unitprice - 工厂报价
     */
    public BigDecimal getUnitprice() {
        return unitprice;
    }

    /**
     * 设置工厂报价
     *
     * @param unitprice 工厂报价
     */
    public void setUnitprice(BigDecimal unitprice) {
        this.unitprice = unitprice;
    }

    /**
     * 获取报价单位
     *
     * @return unitprice_unit - 报价单位
     */
    public String getUnitprice_unit() {
        return unitprice_unit;
    }

    /**
     * 设置报价单位
     *
     * @param unitprice_unit 报价单位
     */
    public void setUnitprice_unit(String unitprice_unit) {
        this.unitprice_unit = unitprice_unit;
    }

    /**
     * 获取条款
     *
     * @return term - 条款
     */
    public String getTerm() {
        return term;
    }

    /**
     * 设置条款
     *
     * @param term 条款
     */
    public void setTerm(String term) {
        this.term = term;
    }
}