package com.nssoft.generator.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "CHAJA_DT_RATE")
public class ChajaDtRate {
    /**
     * 源货币
     */
    @Id
    private String scur;

    /**
     * 目标货币
     */
    @Id
    private String tcur;

    /**
     * 时间
     */
    @Id
    private Date reg_ts;

    /**
     * 汇率
     */
    private BigDecimal rate;

    /**
     * 汇率名
     */
    private String rate_nm;

    /**
     * 状态
     */
    private String status;

    /**
     * 获取源货币
     *
     * @return scur - 源货币
     */
    public String getScur() {
        return scur;
    }

    /**
     * 设置源货币
     *
     * @param scur 源货币
     */
    public void setScur(String scur) {
        this.scur = scur;
    }

    /**
     * 获取目标货币
     *
     * @return tcur - 目标货币
     */
    public String getTcur() {
        return tcur;
    }

    /**
     * 设置目标货币
     *
     * @param tcur 目标货币
     */
    public void setTcur(String tcur) {
        this.tcur = tcur;
    }

    /**
     * 获取时间
     *
     * @return reg_ts - 时间
     */
    public Date getReg_ts() {
        return reg_ts;
    }

    /**
     * 设置时间
     *
     * @param reg_ts 时间
     */
    public void setReg_ts(Date reg_ts) {
        this.reg_ts = reg_ts;
    }

    /**
     * 获取汇率
     *
     * @return rate - 汇率
     */
    public BigDecimal getRate() {
        return rate;
    }

    /**
     * 设置汇率
     *
     * @param rate 汇率
     */
    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    /**
     * 获取汇率名
     *
     * @return rate_nm - 汇率名
     */
    public String getRate_nm() {
        return rate_nm;
    }

    /**
     * 设置汇率名
     *
     * @param rate_nm 汇率名
     */
    public void setRate_nm(String rate_nm) {
        this.rate_nm = rate_nm;
    }

    /**
     * 获取状态
     *
     * @return status - 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(String status) {
        this.status = status;
    }
}