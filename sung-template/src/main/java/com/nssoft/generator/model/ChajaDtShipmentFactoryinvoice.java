package com.nssoft.generator.model;

import javax.persistence.*;

@Table(name = "CHAJA_DT_SHIPMENT_FACTORYINVOICE")
public class ChajaDtShipmentFactoryinvoice {
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
     * 工厂ID
     */
    @Id
    private String factory_id;

    /**
     * 工厂相当发票
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
     * 获取工厂ID
     *
     * @return factory_id - 工厂ID
     */
    public String getFactory_id() {
        return factory_id;
    }

    /**
     * 设置工厂ID
     *
     * @param factory_id 工厂ID
     */
    public void setFactory_id(String factory_id) {
        this.factory_id = factory_id;
    }

    /**
     * 获取工厂相当发票
     *
     * @return invoice_no - 工厂相当发票
     */
    public String getInvoice_no() {
        return invoice_no;
    }

    /**
     * 设置工厂相当发票
     *
     * @param invoice_no 工厂相当发票
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