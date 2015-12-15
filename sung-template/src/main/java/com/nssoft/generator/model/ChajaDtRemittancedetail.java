package com.nssoft.generator.model;

import javax.persistence.*;

@Table(name = "CHAJA_DT_REMITTANCEDETAIL")
public class ChajaDtRemittancedetail {
    /**
     * 汇款编号
     */
    @Id
    private String remittance_id;

    /**
     * 日本发票号
     */
    @Id
    private String invoice_no;

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
     * 获取日本发票号
     *
     * @return invoice_no - 日本发票号
     */
    public String getInvoice_no() {
        return invoice_no;
    }

    /**
     * 设置日本发票号
     *
     * @param invoice_no 日本发票号
     */
    public void setInvoice_no(String invoice_no) {
        this.invoice_no = invoice_no;
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