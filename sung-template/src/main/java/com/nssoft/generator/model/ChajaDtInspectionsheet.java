package com.nssoft.generator.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "CHAJA_DT_INSPECTIONSHEET")
public class ChajaDtInspectionsheet {
    /**
     * 订单编号
     */
    @Id
    private String order_no;

    /**
     * 检验日期
     */
    @Id
    private Date inspecter_date;

    /**
     * 原始出货时间
     */
    private Date orginal_shipment_date;

    /**
     * 工厂名
     */
    private String fty_name;

    /**
     * 款号
     */
    private String item_no;

    /**
     * 中包装
     */
    private String packing;

    /**
     * 中包装尺寸
     */
    private String inner_size;

    /**
     * 大箱尺寸
     */
    private String ctn_size;

    /**
     * 检验人
     */
    private String inspecter_name;

    /**
     * 备注
     */
    private String comments;

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
     * 获取检验日期
     *
     * @return inspecter_date - 检验日期
     */
    public Date getInspecter_date() {
        return inspecter_date;
    }

    /**
     * 设置检验日期
     *
     * @param inspecter_date 检验日期
     */
    public void setInspecter_date(Date inspecter_date) {
        this.inspecter_date = inspecter_date;
    }

    /**
     * 获取原始出货时间
     *
     * @return orginal_shipment_date - 原始出货时间
     */
    public Date getOrginal_shipment_date() {
        return orginal_shipment_date;
    }

    /**
     * 设置原始出货时间
     *
     * @param orginal_shipment_date 原始出货时间
     */
    public void setOrginal_shipment_date(Date orginal_shipment_date) {
        this.orginal_shipment_date = orginal_shipment_date;
    }

    /**
     * 获取工厂名
     *
     * @return fty_name - 工厂名
     */
    public String getFty_name() {
        return fty_name;
    }

    /**
     * 设置工厂名
     *
     * @param fty_name 工厂名
     */
    public void setFty_name(String fty_name) {
        this.fty_name = fty_name;
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
     * 获取中包装
     *
     * @return packing - 中包装
     */
    public String getPacking() {
        return packing;
    }

    /**
     * 设置中包装
     *
     * @param packing 中包装
     */
    public void setPacking(String packing) {
        this.packing = packing;
    }

    /**
     * 获取中包装尺寸
     *
     * @return inner_size - 中包装尺寸
     */
    public String getInner_size() {
        return inner_size;
    }

    /**
     * 设置中包装尺寸
     *
     * @param inner_size 中包装尺寸
     */
    public void setInner_size(String inner_size) {
        this.inner_size = inner_size;
    }

    /**
     * 获取大箱尺寸
     *
     * @return ctn_size - 大箱尺寸
     */
    public String getCtn_size() {
        return ctn_size;
    }

    /**
     * 设置大箱尺寸
     *
     * @param ctn_size 大箱尺寸
     */
    public void setCtn_size(String ctn_size) {
        this.ctn_size = ctn_size;
    }

    /**
     * 获取检验人
     *
     * @return inspecter_name - 检验人
     */
    public String getInspecter_name() {
        return inspecter_name;
    }

    /**
     * 设置检验人
     *
     * @param inspecter_name 检验人
     */
    public void setInspecter_name(String inspecter_name) {
        this.inspecter_name = inspecter_name;
    }

    /**
     * 获取备注
     *
     * @return comments - 备注
     */
    public String getComments() {
        return comments;
    }

    /**
     * 设置备注
     *
     * @param comments 备注
     */
    public void setComments(String comments) {
        this.comments = comments;
    }
}