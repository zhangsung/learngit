package com.nssoft.generator.model;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "CHAJA_DT_SHIPMENTDETAIL")
public class ChajaDtShipmentdetail {
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
     * 订单号
     */
    @Id
    private String order_no;

    /**
     * 颜色
     */
    @Id
    private String color;

    /**
     * 商检
     */
    private String cn_group;

    /**
     * 类别
     */
    private String classification;

    /**
     * 件数
     */
    private Integer pcs;

    /**
     * 箱数
     */
    private Integer ctns;

    /**
     * 单价
     */
    private BigDecimal price;

    /**
     * 总价
     */
    private BigDecimal amount;

    /**
     * 预付款
     */
    private BigDecimal deposit;

    /**
     * 余款
     */
    private BigDecimal ttl;

    /**
     * 方数
     */
    private BigDecimal cbm;

    /**
     * 净重
     */
    private BigDecimal nw;

    /**
     * 毛重
     */
    private BigDecimal gw;

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
     * 获取订单号
     *
     * @return order_no - 订单号
     */
    public String getOrder_no() {
        return order_no;
    }

    /**
     * 设置订单号
     *
     * @param order_no 订单号
     */
    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    /**
     * 获取颜色
     *
     * @return color - 颜色
     */
    public String getColor() {
        return color;
    }

    /**
     * 设置颜色
     *
     * @param color 颜色
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * 获取商检
     *
     * @return cn_group - 商检
     */
    public String getCn_group() {
        return cn_group;
    }

    /**
     * 设置商检
     *
     * @param cn_group 商检
     */
    public void setCn_group(String cn_group) {
        this.cn_group = cn_group;
    }

    /**
     * 获取类别
     *
     * @return classification - 类别
     */
    public String getClassification() {
        return classification;
    }

    /**
     * 设置类别
     *
     * @param classification 类别
     */
    public void setClassification(String classification) {
        this.classification = classification;
    }

    /**
     * 获取件数
     *
     * @return pcs - 件数
     */
    public Integer getPcs() {
        return pcs;
    }

    /**
     * 设置件数
     *
     * @param pcs 件数
     */
    public void setPcs(Integer pcs) {
        this.pcs = pcs;
    }

    /**
     * 获取箱数
     *
     * @return ctns - 箱数
     */
    public Integer getCtns() {
        return ctns;
    }

    /**
     * 设置箱数
     *
     * @param ctns 箱数
     */
    public void setCtns(Integer ctns) {
        this.ctns = ctns;
    }

    /**
     * 获取单价
     *
     * @return price - 单价
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置单价
     *
     * @param price 单价
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取总价
     *
     * @return amount - 总价
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * 设置总价
     *
     * @param amount 总价
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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
     * 获取方数
     *
     * @return cbm - 方数
     */
    public BigDecimal getCbm() {
        return cbm;
    }

    /**
     * 设置方数
     *
     * @param cbm 方数
     */
    public void setCbm(BigDecimal cbm) {
        this.cbm = cbm;
    }

    /**
     * 获取净重
     *
     * @return nw - 净重
     */
    public BigDecimal getNw() {
        return nw;
    }

    /**
     * 设置净重
     *
     * @param nw 净重
     */
    public void setNw(BigDecimal nw) {
        this.nw = nw;
    }

    /**
     * 获取毛重
     *
     * @return gw - 毛重
     */
    public BigDecimal getGw() {
        return gw;
    }

    /**
     * 设置毛重
     *
     * @param gw 毛重
     */
    public void setGw(BigDecimal gw) {
        this.gw = gw;
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