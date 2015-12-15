package com.nssoft.generator.model;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "CHAJA_DT_CARTONINFO")
public class ChajaDtCartoninfo {
    /**
     * 订单号
     */
    @Id
    private String order_no;

    /**
     * 款号
     */
    private String item_no;

    /**
     * 品名
     */
    private String item_nm;

    /**
     * 大箱包装
     */
    private String ctn_packing;

    /**
     * 内盒包装
     */
    private String inner_packing;

    /**
     * 净重
     */
    private BigDecimal box_nw;

    /**
     * 毛重
     */
    private BigDecimal box_gw;

    /**
     * 大箱长
     */
    private BigDecimal box_length;

    /**
     * 大箱宽
     */
    private BigDecimal box_width;

    /**
     * 大箱高
     */
    private BigDecimal box_height;

    /**
     * 大箱尺寸单位
     */
    private String box_size_unit;

    /**
     * 订单箱数
     */
    private Integer order_ctns;

    /**
     * 备注
     */
    private String exp;

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
     * 获取款号
     *
     * @return item_no - 款号
     */
    public String getItem_no() {
        return item_no;
    }

    /**
     * 设置款号
     *
     * @param item_no 款号
     */
    public void setItem_no(String item_no) {
        this.item_no = item_no;
    }

    /**
     * 获取品名
     *
     * @return item_nm - 品名
     */
    public String getItem_nm() {
        return item_nm;
    }

    /**
     * 设置品名
     *
     * @param item_nm 品名
     */
    public void setItem_nm(String item_nm) {
        this.item_nm = item_nm;
    }

    /**
     * 获取大箱包装
     *
     * @return ctn_packing - 大箱包装
     */
    public String getCtn_packing() {
        return ctn_packing;
    }

    /**
     * 设置大箱包装
     *
     * @param ctn_packing 大箱包装
     */
    public void setCtn_packing(String ctn_packing) {
        this.ctn_packing = ctn_packing;
    }

    /**
     * 获取内盒包装
     *
     * @return inner_packing - 内盒包装
     */
    public String getInner_packing() {
        return inner_packing;
    }

    /**
     * 设置内盒包装
     *
     * @param inner_packing 内盒包装
     */
    public void setInner_packing(String inner_packing) {
        this.inner_packing = inner_packing;
    }

    /**
     * 获取净重
     *
     * @return box_nw - 净重
     */
    public BigDecimal getBox_nw() {
        return box_nw;
    }

    /**
     * 设置净重
     *
     * @param box_nw 净重
     */
    public void setBox_nw(BigDecimal box_nw) {
        this.box_nw = box_nw;
    }

    /**
     * 获取毛重
     *
     * @return box_gw - 毛重
     */
    public BigDecimal getBox_gw() {
        return box_gw;
    }

    /**
     * 设置毛重
     *
     * @param box_gw 毛重
     */
    public void setBox_gw(BigDecimal box_gw) {
        this.box_gw = box_gw;
    }

    /**
     * 获取大箱长
     *
     * @return box_length - 大箱长
     */
    public BigDecimal getBox_length() {
        return box_length;
    }

    /**
     * 设置大箱长
     *
     * @param box_length 大箱长
     */
    public void setBox_length(BigDecimal box_length) {
        this.box_length = box_length;
    }

    /**
     * 获取大箱宽
     *
     * @return box_width - 大箱宽
     */
    public BigDecimal getBox_width() {
        return box_width;
    }

    /**
     * 设置大箱宽
     *
     * @param box_width 大箱宽
     */
    public void setBox_width(BigDecimal box_width) {
        this.box_width = box_width;
    }

    /**
     * 获取大箱高
     *
     * @return box_height - 大箱高
     */
    public BigDecimal getBox_height() {
        return box_height;
    }

    /**
     * 设置大箱高
     *
     * @param box_height 大箱高
     */
    public void setBox_height(BigDecimal box_height) {
        this.box_height = box_height;
    }

    /**
     * 获取大箱尺寸单位
     *
     * @return box_size_unit - 大箱尺寸单位
     */
    public String getBox_size_unit() {
        return box_size_unit;
    }

    /**
     * 设置大箱尺寸单位
     *
     * @param box_size_unit 大箱尺寸单位
     */
    public void setBox_size_unit(String box_size_unit) {
        this.box_size_unit = box_size_unit;
    }

    /**
     * 获取订单箱数
     *
     * @return order_ctns - 订单箱数
     */
    public Integer getOrder_ctns() {
        return order_ctns;
    }

    /**
     * 设置订单箱数
     *
     * @param order_ctns 订单箱数
     */
    public void setOrder_ctns(Integer order_ctns) {
        this.order_ctns = order_ctns;
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