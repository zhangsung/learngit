package com.nssoft.generator.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "CHAJA_DT_REMITTANCESAMPLECOST")
public class ChajaDtRemittancesamplecost {
    /**
     * 汇款编号
     */
    @Id
    private String remittance_id;

    /**
     * 开发日期
     */
    @Id
    private Date reg_date;

    /**
     * 开发记录号
     */
    @Id
    private String develop_no;

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
     * 获取开发日期
     *
     * @return reg_date - 开发日期
     */
    public Date getReg_date() {
        return reg_date;
    }

    /**
     * 设置开发日期
     *
     * @param reg_date 开发日期
     */
    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }

    /**
     * 获取开发记录号
     *
     * @return develop_no - 开发记录号
     */
    public String getDevelop_no() {
        return develop_no;
    }

    /**
     * 设置开发记录号
     *
     * @param develop_no 开发记录号
     */
    public void setDevelop_no(String develop_no) {
        this.develop_no = develop_no;
    }
}