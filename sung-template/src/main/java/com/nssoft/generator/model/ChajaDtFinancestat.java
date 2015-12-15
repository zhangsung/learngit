package com.nssoft.generator.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "CHAJA_DT_FINANCESTAT")
public class ChajaDtFinancestat {
    /**
     * 统计日期
     */
    @Id
    private Date reg_date;

    /**
     * 银行余额
     */
    private BigDecimal bank_balance;

    /**
     * 应收货款
     */
    private BigDecimal trade_receivable;

    /**
     * 预付货款
     */
    private BigDecimal deposit;

    /**
     * 库存
     */
    private BigDecimal stock;

    /**
     * 其他应收款
     */
    private BigDecimal other_receivable;

    /**
     * 固定资产
     */
    private BigDecimal permanent_assets;

    /**
     * 累计折旧
     */
    private BigDecimal depreciation;

    /**
     * 应付货款
     */
    private BigDecimal trade_payable;

    /**
     * 其他应付
     */
    private BigDecimal other_payable;

    /**
     * 应交税款
     */
    private BigDecimal taxes_payable;

    /**
     * 实收资本
     */
    private BigDecimal paid_in_capital;

    /**
     * 本年利润
     */
    private BigDecimal current_year_profit;

    /**
     * 利润分配
     */
    private BigDecimal profit_split;

    /**
     * 应收总价
     */
    private BigDecimal total_receivable;

    /**
     * 应付总价
     */
    private BigDecimal total_payable;

    /**
     * 获取统计日期
     *
     * @return reg_date - 统计日期
     */
    public Date getReg_date() {
        return reg_date;
    }

    /**
     * 设置统计日期
     *
     * @param reg_date 统计日期
     */
    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }

    /**
     * 获取银行余额
     *
     * @return bank_balance - 银行余额
     */
    public BigDecimal getBank_balance() {
        return bank_balance;
    }

    /**
     * 设置银行余额
     *
     * @param bank_balance 银行余额
     */
    public void setBank_balance(BigDecimal bank_balance) {
        this.bank_balance = bank_balance;
    }

    /**
     * 获取应收货款
     *
     * @return trade_receivable - 应收货款
     */
    public BigDecimal getTrade_receivable() {
        return trade_receivable;
    }

    /**
     * 设置应收货款
     *
     * @param trade_receivable 应收货款
     */
    public void setTrade_receivable(BigDecimal trade_receivable) {
        this.trade_receivable = trade_receivable;
    }

    /**
     * 获取预付货款
     *
     * @return deposit - 预付货款
     */
    public BigDecimal getDeposit() {
        return deposit;
    }

    /**
     * 设置预付货款
     *
     * @param deposit 预付货款
     */
    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    /**
     * 获取库存
     *
     * @return stock - 库存
     */
    public BigDecimal getStock() {
        return stock;
    }

    /**
     * 设置库存
     *
     * @param stock 库存
     */
    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }

    /**
     * 获取其他应收款
     *
     * @return other_receivable - 其他应收款
     */
    public BigDecimal getOther_receivable() {
        return other_receivable;
    }

    /**
     * 设置其他应收款
     *
     * @param other_receivable 其他应收款
     */
    public void setOther_receivable(BigDecimal other_receivable) {
        this.other_receivable = other_receivable;
    }

    /**
     * 获取固定资产
     *
     * @return permanent_assets - 固定资产
     */
    public BigDecimal getPermanent_assets() {
        return permanent_assets;
    }

    /**
     * 设置固定资产
     *
     * @param permanent_assets 固定资产
     */
    public void setPermanent_assets(BigDecimal permanent_assets) {
        this.permanent_assets = permanent_assets;
    }

    /**
     * 获取累计折旧
     *
     * @return depreciation - 累计折旧
     */
    public BigDecimal getDepreciation() {
        return depreciation;
    }

    /**
     * 设置累计折旧
     *
     * @param depreciation 累计折旧
     */
    public void setDepreciation(BigDecimal depreciation) {
        this.depreciation = depreciation;
    }

    /**
     * 获取应付货款
     *
     * @return trade_payable - 应付货款
     */
    public BigDecimal getTrade_payable() {
        return trade_payable;
    }

    /**
     * 设置应付货款
     *
     * @param trade_payable 应付货款
     */
    public void setTrade_payable(BigDecimal trade_payable) {
        this.trade_payable = trade_payable;
    }

    /**
     * 获取其他应付
     *
     * @return other_payable - 其他应付
     */
    public BigDecimal getOther_payable() {
        return other_payable;
    }

    /**
     * 设置其他应付
     *
     * @param other_payable 其他应付
     */
    public void setOther_payable(BigDecimal other_payable) {
        this.other_payable = other_payable;
    }

    /**
     * 获取应交税款
     *
     * @return taxes_payable - 应交税款
     */
    public BigDecimal getTaxes_payable() {
        return taxes_payable;
    }

    /**
     * 设置应交税款
     *
     * @param taxes_payable 应交税款
     */
    public void setTaxes_payable(BigDecimal taxes_payable) {
        this.taxes_payable = taxes_payable;
    }

    /**
     * 获取实收资本
     *
     * @return paid_in_capital - 实收资本
     */
    public BigDecimal getPaid_in_capital() {
        return paid_in_capital;
    }

    /**
     * 设置实收资本
     *
     * @param paid_in_capital 实收资本
     */
    public void setPaid_in_capital(BigDecimal paid_in_capital) {
        this.paid_in_capital = paid_in_capital;
    }

    /**
     * 获取本年利润
     *
     * @return current_year_profit - 本年利润
     */
    public BigDecimal getCurrent_year_profit() {
        return current_year_profit;
    }

    /**
     * 设置本年利润
     *
     * @param current_year_profit 本年利润
     */
    public void setCurrent_year_profit(BigDecimal current_year_profit) {
        this.current_year_profit = current_year_profit;
    }

    /**
     * 获取利润分配
     *
     * @return profit_split - 利润分配
     */
    public BigDecimal getProfit_split() {
        return profit_split;
    }

    /**
     * 设置利润分配
     *
     * @param profit_split 利润分配
     */
    public void setProfit_split(BigDecimal profit_split) {
        this.profit_split = profit_split;
    }

    /**
     * 获取应收总价
     *
     * @return total_receivable - 应收总价
     */
    public BigDecimal getTotal_receivable() {
        return total_receivable;
    }

    /**
     * 设置应收总价
     *
     * @param total_receivable 应收总价
     */
    public void setTotal_receivable(BigDecimal total_receivable) {
        this.total_receivable = total_receivable;
    }

    /**
     * 获取应付总价
     *
     * @return total_payable - 应付总价
     */
    public BigDecimal getTotal_payable() {
        return total_payable;
    }

    /**
     * 设置应付总价
     *
     * @param total_payable 应付总价
     */
    public void setTotal_payable(BigDecimal total_payable) {
        this.total_payable = total_payable;
    }
}