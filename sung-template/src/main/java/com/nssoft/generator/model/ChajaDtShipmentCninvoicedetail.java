package com.nssoft.generator.model;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "CHAJA_DT_SHIPMENT_CNINVOICEDETAIL")
public class ChajaDtShipmentCninvoicedetail {
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
     * 类别
     */
    @Id
    private String classification;

    /**
     * 商检
     */
    private String commodity_inspection;

    /**
     * 退税率
     */
    private Short taxrefund_rate;

    /**
     * 类别名称
     */
    private String classification_nm;

    /**
     * 件数
     */
    private Integer pcs;

    /**
     * 箱数
     */
    private Integer ctns;

    /**
     * 总金额
     */
    private BigDecimal amount;

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
     * 获取商检
     *
     * @return commodity_inspection - 商检
     */
    public String getCommodity_inspection() {
        return commodity_inspection;
    }

    /**
     * 设置商检
     *
     * @param commodity_inspection 商检
     */
    public void setCommodity_inspection(String commodity_inspection) {
        this.commodity_inspection = commodity_inspection;
    }

    /**
     * 获取退税率
     *
     * @return taxrefund_rate - 退税率
     */
    public Short getTaxrefund_rate() {
        return taxrefund_rate;
    }

    /**
     * 设置退税率
     *
     * @param taxrefund_rate 退税率
     */
    public void setTaxrefund_rate(Short taxrefund_rate) {
        this.taxrefund_rate = taxrefund_rate;
    }

    /**
     * 获取类别名称
     *
     * @return classification_nm - 类别名称
     */
    public String getClassification_nm() {
        return classification_nm;
    }

    /**
     * 设置类别名称
     *
     * @param classification_nm 类别名称
     */
    public void setClassification_nm(String classification_nm) {
        this.classification_nm = classification_nm;
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
     * 获取总金额
     *
     * @return amount - 总金额
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * 设置总金额
     *
     * @param amount 总金额
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}