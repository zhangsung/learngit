package com.nssoft.generator.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "CHAJA_DT_CONTRACTINFO")
public class ChajaDtContractinfo {
    /**
     * 合同号
     */
    @Id
    private String contract_no;

    /**
     * 合同类型
     */
    private String contract_type;

    /**
     * 万青类型
     */
    private String chaja_type;

    /**
     * 担当
     */
    private String sign;

    /**
     * 乙方
     */
    private String sign_party;

    /**
     * 签订日期
     */
    private Date sign_date;

    /**
     * 签订地点
     */
    private String sign_address;

    /**
     * 条款
     */
    private String term;

    private String send_from_to;

    /**
     * 总金额
     */
    private BigDecimal total_amount;

    /**
     * 是否支付预付款
     */
    private String deposit_yn;

    /**
     * 预付款
     */
    private BigDecimal deposit;

    /**
     * 交货港
     */
    private String port_shipment;

    /**
     * 备注
     */
    private String exp;

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
     * 获取合同类型
     *
     * @return contract_type - 合同类型
     */
    public String getContract_type() {
        return contract_type;
    }

    /**
     * 设置合同类型
     *
     * @param contract_type 合同类型
     */
    public void setContract_type(String contract_type) {
        this.contract_type = contract_type;
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
     * 获取担当
     *
     * @return sign - 担当
     */
    public String getSign() {
        return sign;
    }

    /**
     * 设置担当
     *
     * @param sign 担当
     */
    public void setSign(String sign) {
        this.sign = sign;
    }

    /**
     * 获取乙方
     *
     * @return sign_party - 乙方
     */
    public String getSign_party() {
        return sign_party;
    }

    /**
     * 设置乙方
     *
     * @param sign_party 乙方
     */
    public void setSign_party(String sign_party) {
        this.sign_party = sign_party;
    }

    /**
     * 获取签订日期
     *
     * @return sign_date - 签订日期
     */
    public Date getSign_date() {
        return sign_date;
    }

    /**
     * 设置签订日期
     *
     * @param sign_date 签订日期
     */
    public void setSign_date(Date sign_date) {
        this.sign_date = sign_date;
    }

    /**
     * 获取签订地点
     *
     * @return sign_address - 签订地点
     */
    public String getSign_address() {
        return sign_address;
    }

    /**
     * 设置签订地点
     *
     * @param sign_address 签订地点
     */
    public void setSign_address(String sign_address) {
        this.sign_address = sign_address;
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

    /**
     * @return send_from_to
     */
    public String getSend_from_to() {
        return send_from_to;
    }

    /**
     * @param send_from_to
     */
    public void setSend_from_to(String send_from_to) {
        this.send_from_to = send_from_to;
    }

    /**
     * 获取总金额
     *
     * @return total_amount - 总金额
     */
    public BigDecimal getTotal_amount() {
        return total_amount;
    }

    /**
     * 设置总金额
     *
     * @param total_amount 总金额
     */
    public void setTotal_amount(BigDecimal total_amount) {
        this.total_amount = total_amount;
    }

    /**
     * 获取是否支付预付款
     *
     * @return deposit_yn - 是否支付预付款
     */
    public String getDeposit_yn() {
        return deposit_yn;
    }

    /**
     * 设置是否支付预付款
     *
     * @param deposit_yn 是否支付预付款
     */
    public void setDeposit_yn(String deposit_yn) {
        this.deposit_yn = deposit_yn;
    }

    /**
     * 获取预付款
     *
     * @return deposit - 预付款
     */
    public BigDecimal getDeposit() {
        return deposit;
    }

    /**
     * 设置预付款
     *
     * @param deposit 预付款
     */
    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    /**
     * 获取交货港
     *
     * @return port_shipment - 交货港
     */
    public String getPort_shipment() {
        return port_shipment;
    }

    /**
     * 设置交货港
     *
     * @param port_shipment 交货港
     */
    public void setPort_shipment(String port_shipment) {
        this.port_shipment = port_shipment;
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