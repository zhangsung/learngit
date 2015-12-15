package com.nssoft.generator.model;

import javax.persistence.*;

@Table(name = "CHAJA_DT_PACKINGINFO")
public class ChajaDtPackinginfo {
    /**
     * 订单编号
     */
    @Id
    private String order_no;

    /**
     * 颜色
     */
    @Id
    private String color;

    /**
     * 日本条形码
     */
    private String jan_code;

    /**
     * 内盒配比
     */
    private Integer inner_packing;

    /**
     * 件数
     */
    private Integer pcs;

    /**
     * 件数库存
     */
    private Integer pcs_stock;

    /**
     * 箱数
     */
    private Integer ctns;

    /**
     * 箱数库存
     */
    private Integer ctns_stock;

    /**
     * 获取订单编号
     *
     * @return order_no - 订单编号
     */
    public String getOrder_no() {
        return order_no;
    }

    /**
     * 设置订单编号
     *
     * @param order_no 订单编号
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
     * 获取日本条形码
     *
     * @return jan_code - 日本条形码
     */
    public String getJan_code() {
        return jan_code;
    }

    /**
     * 设置日本条形码
     *
     * @param jan_code 日本条形码
     */
    public void setJan_code(String jan_code) {
        this.jan_code = jan_code;
    }

    /**
     * 获取内盒配比
     *
     * @return inner_packing - 内盒配比
     */
    public Integer getInner_packing() {
        return inner_packing;
    }

    /**
     * 设置内盒配比
     *
     * @param inner_packing 内盒配比
     */
    public void setInner_packing(Integer inner_packing) {
        this.inner_packing = inner_packing;
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
     * 获取件数库存
     *
     * @return pcs_stock - 件数库存
     */
    public Integer getPcs_stock() {
        return pcs_stock;
    }

    /**
     * 设置件数库存
     *
     * @param pcs_stock 件数库存
     */
    public void setPcs_stock(Integer pcs_stock) {
        this.pcs_stock = pcs_stock;
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
     * 获取箱数库存
     *
     * @return ctns_stock - 箱数库存
     */
    public Integer getCtns_stock() {
        return ctns_stock;
    }

    /**
     * 设置箱数库存
     *
     * @param ctns_stock 箱数库存
     */
    public void setCtns_stock(Integer ctns_stock) {
        this.ctns_stock = ctns_stock;
    }
}