package com.nssoft.generator.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "CHAJA_DT_SHIPMENT")
public class ChajaDtShipment {
    /**
     * 出货编号
     */
    @Id
    private String shipment_no;

    private String customer_id;

    /**
     * 出货日期
     */
    private Date shipment_date;

    /**
     * 船名/航次
     */
    private String per_vessel;

    /**
     * 信用证号
     */
    private String lc_no;

    /**
     * 发送地
     */
    private String send_addr;

    /**
     * 目的地
     */
    private String destination;

    /**
     * 运送条款
     */
    private String delivery_terms;

    /**
     * 装船日期
     */
    private Date sailing_date;

    /**
     * 集装箱号
     */
    private String container_no;

    /**
     * 封条号
     */
    private String seal_no;

    /**
     * 申请退税日期
     */
    private Date taxing_date;

    /**
     * 退税日期
     */
    private Date taxed_date;

    /**
     * 退税状态
NOSHIP 未出货
NOTAX 未报税
TAXING 已报税
TAXED 已退税
     */
    private String taxrefund_status;

    /**
     * 港杂费参数
     */
    private Integer handling_charge_param;

    /**
     * 港杂费
     */
    private BigDecimal handling_charge;

    /**
     * 退税金额
     */
    private BigDecimal taxrefund_amount;

    /**
     * 备注
     */
    private String exp;

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
     * @return customer_id
     */
    public String getCustomer_id() {
        return customer_id;
    }

    /**
     * @param customer_id
     */
    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    /**
     * 获取出货日期
     *
     * @return shipment_date - 出货日期
     */
    public Date getShipment_date() {
        return shipment_date;
    }

    /**
     * 设置出货日期
     *
     * @param shipment_date 出货日期
     */
    public void setShipment_date(Date shipment_date) {
        this.shipment_date = shipment_date;
    }

    /**
     * 获取船名/航次
     *
     * @return per_vessel - 船名/航次
     */
    public String getPer_vessel() {
        return per_vessel;
    }

    /**
     * 设置船名/航次
     *
     * @param per_vessel 船名/航次
     */
    public void setPer_vessel(String per_vessel) {
        this.per_vessel = per_vessel;
    }

    /**
     * 获取信用证号
     *
     * @return lc_no - 信用证号
     */
    public String getLc_no() {
        return lc_no;
    }

    /**
     * 设置信用证号
     *
     * @param lc_no 信用证号
     */
    public void setLc_no(String lc_no) {
        this.lc_no = lc_no;
    }

    /**
     * 获取发送地
     *
     * @return send_addr - 发送地
     */
    public String getSend_addr() {
        return send_addr;
    }

    /**
     * 设置发送地
     *
     * @param send_addr 发送地
     */
    public void setSend_addr(String send_addr) {
        this.send_addr = send_addr;
    }

    /**
     * 获取目的地
     *
     * @return destination - 目的地
     */
    public String getDestination() {
        return destination;
    }

    /**
     * 设置目的地
     *
     * @param destination 目的地
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * 获取运送条款
     *
     * @return delivery_terms - 运送条款
     */
    public String getDelivery_terms() {
        return delivery_terms;
    }

    /**
     * 设置运送条款
     *
     * @param delivery_terms 运送条款
     */
    public void setDelivery_terms(String delivery_terms) {
        this.delivery_terms = delivery_terms;
    }

    /**
     * 获取装船日期
     *
     * @return sailing_date - 装船日期
     */
    public Date getSailing_date() {
        return sailing_date;
    }

    /**
     * 设置装船日期
     *
     * @param sailing_date 装船日期
     */
    public void setSailing_date(Date sailing_date) {
        this.sailing_date = sailing_date;
    }

    /**
     * 获取集装箱号
     *
     * @return container_no - 集装箱号
     */
    public String getContainer_no() {
        return container_no;
    }

    /**
     * 设置集装箱号
     *
     * @param container_no 集装箱号
     */
    public void setContainer_no(String container_no) {
        this.container_no = container_no;
    }

    /**
     * 获取封条号
     *
     * @return seal_no - 封条号
     */
    public String getSeal_no() {
        return seal_no;
    }

    /**
     * 设置封条号
     *
     * @param seal_no 封条号
     */
    public void setSeal_no(String seal_no) {
        this.seal_no = seal_no;
    }

    /**
     * 获取申请退税日期
     *
     * @return taxing_date - 申请退税日期
     */
    public Date getTaxing_date() {
        return taxing_date;
    }

    /**
     * 设置申请退税日期
     *
     * @param taxing_date 申请退税日期
     */
    public void setTaxing_date(Date taxing_date) {
        this.taxing_date = taxing_date;
    }

    /**
     * 获取退税日期
     *
     * @return taxed_date - 退税日期
     */
    public Date getTaxed_date() {
        return taxed_date;
    }

    /**
     * 设置退税日期
     *
     * @param taxed_date 退税日期
     */
    public void setTaxed_date(Date taxed_date) {
        this.taxed_date = taxed_date;
    }

    /**
     * 获取退税状态
NOSHIP 未出货
NOTAX 未报税
TAXING 已报税
TAXED 已退税
     *
     * @return taxrefund_status - 退税状态
NOSHIP 未出货
NOTAX 未报税
TAXING 已报税
TAXED 已退税
     */
    public String getTaxrefund_status() {
        return taxrefund_status;
    }

    /**
     * 设置退税状态
NOSHIP 未出货
NOTAX 未报税
TAXING 已报税
TAXED 已退税
     *
     * @param taxrefund_status 退税状态
NOSHIP 未出货
NOTAX 未报税
TAXING 已报税
TAXED 已退税
     */
    public void setTaxrefund_status(String taxrefund_status) {
        this.taxrefund_status = taxrefund_status;
    }

    /**
     * 获取港杂费参数
     *
     * @return handling_charge_param - 港杂费参数
     */
    public Integer getHandling_charge_param() {
        return handling_charge_param;
    }

    /**
     * 设置港杂费参数
     *
     * @param handling_charge_param 港杂费参数
     */
    public void setHandling_charge_param(Integer handling_charge_param) {
        this.handling_charge_param = handling_charge_param;
    }

    /**
     * 获取港杂费
     *
     * @return handling_charge - 港杂费
     */
    public BigDecimal getHandling_charge() {
        return handling_charge;
    }

    /**
     * 设置港杂费
     *
     * @param handling_charge 港杂费
     */
    public void setHandling_charge(BigDecimal handling_charge) {
        this.handling_charge = handling_charge;
    }

    /**
     * 获取退税金额
     *
     * @return taxrefund_amount - 退税金额
     */
    public BigDecimal getTaxrefund_amount() {
        return taxrefund_amount;
    }

    /**
     * 设置退税金额
     *
     * @param taxrefund_amount 退税金额
     */
    public void setTaxrefund_amount(BigDecimal taxrefund_amount) {
        this.taxrefund_amount = taxrefund_amount;
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