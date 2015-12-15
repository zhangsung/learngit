package com.nssoft.generator.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "CHAJA_DT_REMITTANCEINFO")
public class ChajaDtRemittanceinfo {
    /**
     * 汇款编号
     */
    @Id
    private String remittance_id;

    /**
     * 万青类型
     */
    @Id
    private String chaja_type;

    /**
     * 汇款日期
     */
    private Date remittance_date;

    /**
     * 客户编号
     */
    private String customer_id;

    /**
     * LESS总金额
     */
    private BigDecimal less_amount;

    /**
     * 出货尾款
     */
    private BigDecimal shipment_ttl;

    /**
     * 新的预付款
     */
    private BigDecimal new_deposit;

    /**
     * OCS金额
     */
    private BigDecimal ocs_amount;

    private BigDecimal compensation_amount;

    /**
     * 样品费
     */
    private BigDecimal sample_cost;

    /**
     * 模具费
     */
    private BigDecimal mould_cost;

    /**
     * 处理费
     */
    private BigDecimal handling_fee;

    /**
     * 退还模具费
     */
    private BigDecimal return_mould;

    /**
     * 余款
     */
    private BigDecimal balance;

    /**
     * 备注
     */
    private String exp;

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
     * 获取万青类型
     *
     * @return chaja_type - 万青类型
     */
    public String getChaja_type() {
        return chaja_type;
    }

    /**
     * 设置万青类型
     *
     * @param chaja_type 万青类型
     */
    public void setChaja_type(String chaja_type) {
        this.chaja_type = chaja_type;
    }

    /**
     * 获取汇款日期
     *
     * @return remittance_date - 汇款日期
     */
    public Date getRemittance_date() {
        return remittance_date;
    }

    /**
     * 设置汇款日期
     *
     * @param remittance_date 汇款日期
     */
    public void setRemittance_date(Date remittance_date) {
        this.remittance_date = remittance_date;
    }

    /**
     * 获取客户编号
     *
     * @return customer_id - 客户编号
     */
    public String getCustomer_id() {
        return customer_id;
    }

    /**
     * 设置客户编号
     *
     * @param customer_id 客户编号
     */
    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    /**
     * 获取LESS总金额
     *
     * @return less_amount - LESS总金额
     */
    public BigDecimal getLess_amount() {
        return less_amount;
    }

    /**
     * 设置LESS总金额
     *
     * @param less_amount LESS总金额
     */
    public void setLess_amount(BigDecimal less_amount) {
        this.less_amount = less_amount;
    }

    /**
     * 获取出货尾款
     *
     * @return shipment_ttl - 出货尾款
     */
    public BigDecimal getShipment_ttl() {
        return shipment_ttl;
    }

    /**
     * 设置出货尾款
     *
     * @param shipment_ttl 出货尾款
     */
    public void setShipment_ttl(BigDecimal shipment_ttl) {
        this.shipment_ttl = shipment_ttl;
    }

    /**
     * 获取新的预付款
     *
     * @return new_deposit - 新的预付款
     */
    public BigDecimal getNew_deposit() {
        return new_deposit;
    }

    /**
     * 设置新的预付款
     *
     * @param new_deposit 新的预付款
     */
    public void setNew_deposit(BigDecimal new_deposit) {
        this.new_deposit = new_deposit;
    }

    /**
     * 获取OCS金额
     *
     * @return ocs_amount - OCS金额
     */
    public BigDecimal getOcs_amount() {
        return ocs_amount;
    }

    /**
     * 设置OCS金额
     *
     * @param ocs_amount OCS金额
     */
    public void setOcs_amount(BigDecimal ocs_amount) {
        this.ocs_amount = ocs_amount;
    }

    /**
     * @return compensation_amount
     */
    public BigDecimal getCompensation_amount() {
        return compensation_amount;
    }

    /**
     * @param compensation_amount
     */
    public void setCompensation_amount(BigDecimal compensation_amount) {
        this.compensation_amount = compensation_amount;
    }

    /**
     * 获取样品费
     *
     * @return sample_cost - 样品费
     */
    public BigDecimal getSample_cost() {
        return sample_cost;
    }

    /**
     * 设置样品费
     *
     * @param sample_cost 样品费
     */
    public void setSample_cost(BigDecimal sample_cost) {
        this.sample_cost = sample_cost;
    }

    /**
     * 获取模具费
     *
     * @return mould_cost - 模具费
     */
    public BigDecimal getMould_cost() {
        return mould_cost;
    }

    /**
     * 设置模具费
     *
     * @param mould_cost 模具费
     */
    public void setMould_cost(BigDecimal mould_cost) {
        this.mould_cost = mould_cost;
    }

    /**
     * 获取处理费
     *
     * @return handling_fee - 处理费
     */
    public BigDecimal getHandling_fee() {
        return handling_fee;
    }

    /**
     * 设置处理费
     *
     * @param handling_fee 处理费
     */
    public void setHandling_fee(BigDecimal handling_fee) {
        this.handling_fee = handling_fee;
    }

    /**
     * 获取退还模具费
     *
     * @return return_mould - 退还模具费
     */
    public BigDecimal getReturn_mould() {
        return return_mould;
    }

    /**
     * 设置退还模具费
     *
     * @param return_mould 退还模具费
     */
    public void setReturn_mould(BigDecimal return_mould) {
        this.return_mould = return_mould;
    }

    /**
     * 获取余款
     *
     * @return balance - 余款
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * 设置余款
     *
     * @param balance 余款
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
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
}