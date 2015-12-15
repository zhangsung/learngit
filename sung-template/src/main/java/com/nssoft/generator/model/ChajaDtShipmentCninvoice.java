package com.nssoft.generator.model;

import javax.persistence.*;

@Table(name = "CHAJA_DT_SHIPMENT_CNINVOICE")
public class ChajaDtShipmentCninvoice {
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
     * 分组
     */
    @Id
    private String cn_group;

    /**
     * 发票号
     */
    private String invoice_no;

    /**
     * 是否打印
     */
    private String print_yn;

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
     * 获取分组
     *
     * @return cn_group - 分组
     */
    public String getCn_group() {
        return cn_group;
    }

    /**
     * 设置分组
     *
     * @param cn_group 分组
     */
    public void setCn_group(String cn_group) {
        this.cn_group = cn_group;
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
     * 获取是否打印
     *
     * @return print_yn - 是否打印
     */
    public String getPrint_yn() {
        return print_yn;
    }

    /**
     * 设置是否打印
     *
     * @param print_yn 是否打印
     */
    public void setPrint_yn(String print_yn) {
        this.print_yn = print_yn;
    }
}