package com.nssoft.generator.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "CHAJA_DT_INSPECTIONDETAIL")
public class ChajaDtInspectiondetail {
    /**
     * 出货编号
     */
    @Id
    private Date inspecter_date;

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
     * 订单数
     */
    private String order_qty;

    /**
     * 完成订单数
     */
    private String finished_order_qty;

    /**
     * 检验数量
     */
    private String inspected_qty;

    /**
     * 检验箱数
     */
    private String inspected_ctn;

    /**
     * 获取出货编号
     *
     * @return inspecter_date - 出货编号
     */
    public Date getInspecter_date() {
        return inspecter_date;
    }

    /**
     * 设置出货编号
     *
     * @param inspecter_date 出货编号
     */
    public void setInspecter_date(Date inspecter_date) {
        this.inspecter_date = inspecter_date;
    }

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
     * 获取订单数
     *
     * @return order_qty - 订单数
     */
    public String getOrder_qty() {
        return order_qty;
    }

    /**
     * 设置订单数
     *
     * @param order_qty 订单数
     */
    public void setOrder_qty(String order_qty) {
        this.order_qty = order_qty;
    }

    /**
     * 获取完成订单数
     *
     * @return finished_order_qty - 完成订单数
     */
    public String getFinished_order_qty() {
        return finished_order_qty;
    }

    /**
     * 设置完成订单数
     *
     * @param finished_order_qty 完成订单数
     */
    public void setFinished_order_qty(String finished_order_qty) {
        this.finished_order_qty = finished_order_qty;
    }

    /**
     * 获取检验数量
     *
     * @return inspected_qty - 检验数量
     */
    public String getInspected_qty() {
        return inspected_qty;
    }

    /**
     * 设置检验数量
     *
     * @param inspected_qty 检验数量
     */
    public void setInspected_qty(String inspected_qty) {
        this.inspected_qty = inspected_qty;
    }

    /**
     * 获取检验箱数
     *
     * @return inspected_ctn - 检验箱数
     */
    public String getInspected_ctn() {
        return inspected_ctn;
    }

    /**
     * 设置检验箱数
     *
     * @param inspected_ctn 检验箱数
     */
    public void setInspected_ctn(String inspected_ctn) {
        this.inspected_ctn = inspected_ctn;
    }
}