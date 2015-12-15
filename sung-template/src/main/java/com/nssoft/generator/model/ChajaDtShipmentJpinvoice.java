package com.nssoft.generator.model;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "CHAJA_DT_SHIPMENT_JPINVOICE")
public class ChajaDtShipmentJpinvoice {
    /**
     * 出货编号
     */
    @Id
    private String shipment_no;

    /**
     * 万青类型
     */
    @Id
    private String chaja_type;

    /**
     * 发票号
     */
    private String invoice_no;

    /**
     * 发票内容
     */
    private String invoice_item;

    /**
     * 预付款
     */
    private BigDecimal deposit;

    /**
     * 余款
     */
    private BigDecimal ttl;

    private String print_yn;

    private String calculate_yn;

    /**
     * 是否汇款
     */
    private String payed_yn;

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
     * 获取发票号
     *
     * @return invoice_no - 发票号
     */
    public String getInvoice_no() {
        return invoice_no;
    }

    /**
     * 设置发票号
     *
     * @param invoice_no 发票号
     */
    public void setInvoice_no(String invoice_no) {
        this.invoice_no = invoice_no;
    }

    /**
     * 获取发票内容
     *
     * @return invoice_item - 发票内容
     */
    public String getInvoice_item() {
        return invoice_item;
    }

    /**
     * 设置发票内容
     *
     * @param invoice_item 发票内容
     */
    public void setInvoice_item(String invoice_item) {
        this.invoice_item = invoice_item;
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
     * 获取余款
     *
     * @return ttl - 余款
     */
    public BigDecimal getTtl() {
        return ttl;
    }

    /**
     * 设置余款
     *
     * @param ttl 余款
     */
    public void setTtl(BigDecimal ttl) {
        this.ttl = ttl;
    }

    /**
     * @return print_yn
     */
    public String getPrint_yn() {
        return print_yn;
    }

    /**
     * @param print_yn
     */
    public void setPrint_yn(String print_yn) {
        this.print_yn = print_yn;
    }

    /**
     * @return calculate_yn
     */
    public String getCalculate_yn() {
        return calculate_yn;
    }

    /**
     * @param calculate_yn
     */
    public void setCalculate_yn(String calculate_yn) {
        this.calculate_yn = calculate_yn;
    }

    /**
     * 获取是否汇款
     *
     * @return payed_yn - 是否汇款
     */
    public String getPayed_yn() {
        return payed_yn;
    }

    /**
     * 设置是否汇款
     *
     * @param payed_yn 是否汇款
     */
    public void setPayed_yn(String payed_yn) {
        this.payed_yn = payed_yn;
    }
}