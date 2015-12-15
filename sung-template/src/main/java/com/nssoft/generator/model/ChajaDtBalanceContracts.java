package com.nssoft.generator.model;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "CHAJA_DT_BALANCE_CONTRACTS")
public class ChajaDtBalanceContracts {
    /**
     * 汇款编号
     */
    @Id
    private String remittance_id;

    /**
     * 合同号
     */
    @Id
    private String contract_no;

    /**
     * 预付款余款
     */
    private BigDecimal deposit_balance;

    /**
     * 合同余款
     */
    private BigDecimal contract_balance;

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
     * 获取预付款余款
     *
     * @return deposit_balance - 预付款余款
     */
    public BigDecimal getDeposit_balance() {
        return deposit_balance;
    }

    /**
     * 设置预付款余款
     *
     * @param deposit_balance 预付款余款
     */
    public void setDeposit_balance(BigDecimal deposit_balance) {
        this.deposit_balance = deposit_balance;
    }

    /**
     * 获取合同余款
     *
     * @return contract_balance - 合同余款
     */
    public BigDecimal getContract_balance() {
        return contract_balance;
    }

    /**
     * 设置合同余款
     *
     * @param contract_balance 合同余款
     */
    public void setContract_balance(BigDecimal contract_balance) {
        this.contract_balance = contract_balance;
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